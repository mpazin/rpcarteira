package com.rpbank.rpcarteira.rest;

import com.google.gson.Gson;
import com.rpbank.rpcarteira.domain.dto.*;
import com.rpbank.rpcarteira.domain.enums.ErrorCodeEnum;
import com.rpbank.rpcarteira.exception.WalletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Slf4j
@Component
public class RpBaseRest {

    @Value("${serviceRPCadastro}")
    private String endpoint;
    @Value("${serviceWalletBalance}")
    private String endpointBalance;

    @Value("${serviceWalletDeposit}")
    private String endpointDeposit;

    @Value("${serviceWalletWithdrawal}")
    private String endpointWithdrawal;

    @Value("${serviceWalletTransfer}")
    private String endpointTransfer;

    @Value("${serviceBalanceHistory}")
    private String endpointBalanceHistory;

    private RestTemplate restTemplate = new RestTemplate();

    Gson gson = new Gson();

    /**
     * Acessa MS para criar nova conta
     */
    public WalletNewAccountResponseDTO enpointNewAccount(WalletNewAccountDTO walletNewAccountDTO) {

        log.info("serviço: {}", endpoint);
        try {
            String walletNewAccountJson = gson.toJson(walletNewAccountDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(walletNewAccountJson, headers);

            WalletNewAccountResponseDTO retorno = restTemplate.postForObject(endpoint, request, WalletNewAccountResponseDTO.class);
            log.info("ret: {}", retorno);
            if (retorno == null) {
                throw new WalletException(ErrorCodeEnum.ERROR_REGISTERING_NEW_ACCOUNT);
            }
            return retorno;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new WalletException(ErrorCodeEnum.ERROR_REGISTERING_NEW_ACCOUNT);
        }

    }


    /**
     * Acessa MS consultar saldo
     */
    public ResponseWalletBalanceDTO enpointGetWalletBalance(String nuConta) {

        log.info("serviço: {}", endpointBalance);
        try {

            ResponseWalletBalanceDTO retorno = restTemplate.getForObject(endpointBalance + "?nuConta=" + nuConta, ResponseWalletBalanceDTO.class);
            log.info("ret: {}", retorno);

            return retorno;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new WalletException(ErrorCodeEnum.ERROR_GET_WALLET_BALANCE);
        }
    }

    /**
     * Acessa MS depositar valor
     */
    public ResponseWalletDepositDTO enpointDepositWallet(DepositWalletRequestDTO depositWalletRequestDTO) {
        log.info("serviço: {}", endpointDeposit);
        try {
            String walletNewAccountJson = gson.toJson(depositWalletRequestDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(walletNewAccountJson, headers);

            ResponseWalletDepositDTO retorno = restTemplate.postForObject(endpointDeposit, request, ResponseWalletDepositDTO.class);
            log.info("ret: {}", retorno);
            if (retorno == null) {
                throw new WalletException(ErrorCodeEnum.ERROR_DEPOSIT);
            }
            return retorno;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new WalletException(ErrorCodeEnum.ERROR_DEPOSIT);
        }
    }

    /**
     * Acessa MS sacar valor
     */
    public ResponseWalletWithdrawalDTO enpointWithdrawalWallet(WithdrawalWalletRequestDTO withdrawalWalletRequestDTO) {
        log.info("serviço: {}", endpointWithdrawal);
        try {
            String walletNewAccountJson = gson.toJson(withdrawalWalletRequestDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(walletNewAccountJson, headers);

            ResponseWalletWithdrawalDTO retorno = restTemplate.postForObject(endpointWithdrawal, request, ResponseWalletWithdrawalDTO.class);
            log.info("ret: {}", retorno);
            if (retorno == null) {
                throw new WalletException(ErrorCodeEnum.ERROR_WITHDRAWAL);
            }
            return retorno;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new WalletException(ErrorCodeEnum.ERROR_WITHDRAWAL);
        }
    }

    /**
     * Acessa MS transferir valor (Transferencia interna)
     */
    public ResponseTransferDTO enpointTransferWallet(TransferWalletRequestDTO transferWalletRequestDTO) {
        log.info("serviço: {}", endpointTransfer);

        try {
            String walletNewAccountJson = gson.toJson(transferWalletRequestDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(walletNewAccountJson, headers);

            ResponseEntity<ResponseTransferDTO> response = restTemplate.exchange(endpointTransfer, HttpMethod.PUT,request,ResponseTransferDTO.class);


            if (response.getStatusCode().equals(HttpStatus.OK)) {
                log.info("ret: {}", response.getBody());
                return response.getBody();
            }else{
                throw new WalletException(ErrorCodeEnum.ERROR_TRANSFER);
            }


        } catch (Exception e) {
            log.error(e.getMessage());
            throw new WalletException(ErrorCodeEnum.ERROR_TRANSFER);
        }

    }

    /**
     * Acessa MS buscar historico de saldo
     */
    public ResponseWalletBalanceHistoryDTO enpointBalanceHistory(String nuConta, LocalDate dtInicio, LocalDate dtFim) {

        log.info("serviço: {}", endpointBalanceHistory);
        try {

            ResponseWalletBalanceHistoryDTO retorno = restTemplate.getForObject(endpointBalanceHistory + "?nuConta=" + nuConta+"&dtInicio="+dtInicio+"&dtFim="+dtFim, ResponseWalletBalanceHistoryDTO.class);
            if (retorno == null) {
                throw new WalletException(ErrorCodeEnum.ERROR_GET_BALANCE_HISTORY);
            }
            return retorno;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new WalletException(ErrorCodeEnum.ERROR_GET_BALANCE_HISTORY);
        }
    }
}

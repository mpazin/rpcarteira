package com.rpbank.rpcarteira.controller;

import com.rpbank.rpcarteira.domain.dto.*;
import com.rpbank.rpcarteira.domain.enums.ErrorCodeEnum;
import com.rpbank.rpcarteira.exception.WalletException;
import com.rpbank.rpcarteira.service.AccountService;
import com.rpbank.rpcarteira.service.serviceImpl.AccountServiceImpl;
import com.rpbank.rpcarteira.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/wallet")
public class WalletController {

    private final AccountService accountService;

    private final WalletService walletService;

    @PostMapping("/createAccount")
    public ResponseEntity<WalletNewAccountResponseDTO> createWallet(@RequestBody @Valid WalletRequestDTO walletRequestDTO){
        log.info(walletRequestDTO.toString());
        WalletNewAccountResponseDTO account = accountService.createWallet(walletRequestDTO);
        return ResponseEntity.status(200).body(account);
    }

    @GetMapping("/getBalance")
    public ResponseEntity<ResponseWalletBalanceDTO> getBalance(@RequestParam(required = true) String nuConta){
        log.info("numero conta: {}",nuConta);
        ResponseWalletBalanceDTO walletBalance = walletService.getWalletBalance(nuConta);
        if(walletBalance == null){
            throw new WalletException(ErrorCodeEnum.WALLET_DOES_NOT_EXIST);
        }
        return ResponseEntity.status(200).body(walletBalance);
    }

    @PostMapping("/deposit")
    public ResponseEntity<ResponseWalletDepositDTO> depositValueWallet(@RequestBody @Valid DepositWalletRequestDTO depositWalletRequestDTO){
        log.info(depositWalletRequestDTO.toString());
        ResponseWalletDepositDTO deposity = walletService.deposityValue(depositWalletRequestDTO);
        return ResponseEntity.status(200).body(deposity);
    }


    @PostMapping("/withdrawal")
    public ResponseEntity<ResponseWalletWithdrawalDTO> withdrawalValueWallet(@RequestBody @Valid WithdrawalWalletRequestDTO withdrawalWalletRequestDTO){
        log.info(withdrawalWalletRequestDTO.toString());
        ResponseWalletWithdrawalDTO withdrawal = walletService.valueWithdraw(withdrawalWalletRequestDTO);

        return ResponseEntity.status(200).body(withdrawal);
    }

    @PutMapping("/transfer")
    public ResponseEntity<ResponseTransferDTO> valueTransferWallet(@RequestBody @Valid TransferWalletRequestDTO transferWalletRequestDTO){
        log.info(transferWalletRequestDTO.toString());
        ResponseTransferDTO transfer = walletService.valueTransfer(transferWalletRequestDTO);
        return ResponseEntity.status(200).body(transfer);
    }

    @GetMapping("/getBalanceHistory")
    public ResponseEntity<ResponseWalletBalanceHistoryDTO> getBalanceHistory(@RequestParam(required = true) String nuConta,
                                                                 @RequestParam(required = true) LocalDate dtInicio,
                                                                 @RequestParam(required = true) LocalDate dtFim){
        log.info("numero conta: {}",nuConta);
        log.info("data inicio: {} - data final: {}",dtInicio, dtFim);

        ResponseWalletBalanceHistoryDTO balanceHistory = walletService.getBalanceHistory(nuConta, dtInicio, dtFim);
        return ResponseEntity.status(200).body(balanceHistory);
    }



}

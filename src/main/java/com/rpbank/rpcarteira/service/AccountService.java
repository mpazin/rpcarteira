package com.rpbank.rpcarteira.service;

import com.rpbank.rpcarteira.domain.dto.WalletNewAccountDTO;
import com.rpbank.rpcarteira.domain.dto.WalletNewAccountResponseDTO;
import com.rpbank.rpcarteira.domain.dto.WalletRequestDTO;
import com.rpbank.rpcarteira.domain.enums.ErrorCodeEnum;
import com.rpbank.rpcarteira.domain.enums.TipoContaEnum;
import com.rpbank.rpcarteira.exception.WalletException;
import com.rpbank.rpcarteira.rest.RpBaseRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountService {


    @Autowired
    private RpBaseRest rpBaseRest;
    public WalletNewAccountResponseDTO createWallet(WalletRequestDTO walletRequestDTO) {

        TipoContaEnum tpConta = TipoContaEnum.getTipoContaBySigla(walletRequestDTO.getTpConta());

        try {
            return this.rpBaseRest.enpointNewAccount(WalletNewAccountDTO.builder()
                    .nmPessoa(walletRequestDTO.getNmPessoa())
                    .cpfPessoa(walletRequestDTO.getCpfPessoa())
                    .rgPessoa(walletRequestDTO.getRgPessoa())
                    .tpConta(tpConta.getTpConta())
                    .build());

        }catch (Exception e){
            log.error(e.getMessage());
            throw new WalletException(ErrorCodeEnum.ERROR_REGISTERING_NEW_ACCOUNT);
        }
    }
}

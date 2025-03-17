package com.rpbank.rpcarteira.service;

import com.rpbank.rpcarteira.domain.dto.WalletNewAccountResponseDTO;
import com.rpbank.rpcarteira.domain.dto.WalletRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {


    WalletNewAccountResponseDTO createWallet(WalletRequestDTO walletRequestDTO);
}

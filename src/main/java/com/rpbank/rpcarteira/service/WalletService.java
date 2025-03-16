package com.rpbank.rpcarteira.service;


import com.rpbank.rpcarteira.domain.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface WalletService {

    ResponseWalletBalanceDTO getWalletBalance(String nuConta);

    ResponseWalletDepositDTO deposityValue(DepositWalletRequestDTO depositWalletRequestDTO);

    ResponseWalletWithdrawalDTO valueWithdraw(WithdrawalWalletRequestDTO withdrawalWalletRequestDTO);

    ResponseTransferDTO valueTransfer(TransferWalletRequestDTO transferWalletRequestDTO);

    ResponseWalletBalanceHistoryDTO getBalanceHistory(String nuConta, LocalDate dtInicio, LocalDate dtFim);
}

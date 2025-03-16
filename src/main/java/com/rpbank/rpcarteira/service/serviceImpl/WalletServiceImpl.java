package com.rpbank.rpcarteira.service.serviceImpl;

import com.rpbank.rpcarteira.domain.dto.*;
import com.rpbank.rpcarteira.rest.RpBaseRest;
import com.rpbank.rpcarteira.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private RpBaseRest rpBaseRest;

    @Override

    public ResponseWalletBalanceDTO getWalletBalance(String nuConta) {
        return this.rpBaseRest.enpointGetWalletBalance(nuConta);
    }

    @Override
    public ResponseWalletDepositDTO deposityValue(DepositWalletRequestDTO depositWalletRequestDTO) {
        return this.rpBaseRest.enpointDepositWallet(depositWalletRequestDTO);
    }

    @Override
    public ResponseWalletWithdrawalDTO valueWithdraw(WithdrawalWalletRequestDTO withdrawalWalletRequestDTO) {
        return this.rpBaseRest.enpointWithdrawalWallet(withdrawalWalletRequestDTO);
    }

    @Override
    public ResponseTransferDTO valueTransfer(TransferWalletRequestDTO transferWalletRequestDTO) {
        return this.rpBaseRest.enpointTransferWallet(transferWalletRequestDTO);
    }

    @Override
    public ResponseWalletBalanceHistoryDTO getBalanceHistory(String nuConta, LocalDate dtInicio, LocalDate dtFim) {
        return this.rpBaseRest.enpointBalanceHistory(nuConta, dtInicio, dtFim);
    }


}

package com.rpbank.rpcarteira.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ResponseWalletWithdrawalDTO {

    private String message;
    private String codeMessage;
    private Long idCarteira;
    private String nuConta;
    private BigDecimal valorSaque;
    private BigDecimal saldoAtual;
    private String nmPessoa;
    private String cpfPessoa;
    private LocalDateTime dtTransacao;


}

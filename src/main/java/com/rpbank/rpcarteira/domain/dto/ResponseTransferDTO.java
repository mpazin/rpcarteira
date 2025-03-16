package com.rpbank.rpcarteira.domain.dto;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ResponseTransferDTO {

    private String messageInfo;
    private String codeMessage;
    private Long idCarteira;
    private String nuConta;
    private BigDecimal valorTranferencia;
    private BigDecimal saldoAtual;
    private String nmPessoa;
    private String cpfPessoa;
    private String nuContaDestino;
    private String nmDestino;
    private String cpfDestino;
    private String dtTransacao;


    @Override
    public String toString() {
        return "ResponseTransferDTO{" +
                "idCarteira=" + idCarteira +
                ", nuConta='" + nuConta + '\'' +
                ", valorTranferencia=" + valorTranferencia +
                ", saldoAtual=" + saldoAtual +
                ", nmPessoa='" + nmPessoa + '\'' +
                ", cpfPessoa='" + cpfPessoa + '\'' +
                ", nuContaDestino='" + nuContaDestino + '\'' +
                ", nmDestino='" + nmDestino + '\'' +
                ", cpfDestino='" + cpfDestino + '\'' +
                ", dtTransacao='" + dtTransacao + '\'' +
                ", messageInfo='" + messageInfo + '\'' +
                ", codeMessage='" + codeMessage + '\'' +
                '}';
    }
}

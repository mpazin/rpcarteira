package com.rpbank.rpcarteira.domain.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
public class ResponseWalletDepositDTO {

    private String messageInfo;
    private String nuConta;
    private Long idConta;
    private BigDecimal valor;
    private String nmRemetente;
    private String cpfCnpjRemetente;
    private String nmDestinatario;
    private String cpfCnpjDestinatario;
    private BigDecimal saldoAnterior;
    private BigDecimal saldoAtual;
    private String dataTransacao;
    private Long tpTransacao;
    private String cdTransacao;
    private String cdE2E;

}

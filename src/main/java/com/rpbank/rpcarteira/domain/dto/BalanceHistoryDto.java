package com.rpbank.rpcarteira.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BalanceHistoryDto {

    private Long idHistoricoTransacao;
    private String cdTransacao;
    private String dataTransacao;
    private BigDecimal valorTransacao;
    private String descricaoTransacao;
    private BigDecimal saldoDia;
    private Long idConta;
    private String nuContaTitular;
    private String cpfTitular;
    private String nmContaTitular;

}

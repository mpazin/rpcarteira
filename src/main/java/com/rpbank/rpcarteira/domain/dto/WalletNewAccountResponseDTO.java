package com.rpbank.rpcarteira.domain.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@ToString
public class WalletNewAccountResponseDTO {

    private Long idConta;
    private Long idPessoa;
    private String nuConta;
    private Integer nuAgencia;
    private Integer nuBanco;
    private String nmPessoa;
    private String nuCpfPessoa;
    private Integer tpConta;




}


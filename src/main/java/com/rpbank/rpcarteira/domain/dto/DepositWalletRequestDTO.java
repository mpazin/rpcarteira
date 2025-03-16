package com.rpbank.rpcarteira.domain.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class DepositWalletRequestDTO {

    /*Não obrigatorios*/
    private String nmRemetente;
    private String nuContaRemetente;
    private String cpfCnpjRemetente;
    private Integer nuAgenciaRementente;
    private Integer nuBancoRemetente;

    @NotBlank(message = "nmDestinatario não pode ser vazio")
    private String nmDestinatario;

    @NotBlank(message = "contaDestinatario não pode ser vazio")
    private String nuContaDestinatario;

    @NotBlank(message = "cpfCnpjDestinatario não pode ser vazio")
    private String cpfCnpjDestinatario;

    @NotNull
    private Integer nuAgenciaDestinatario;

    @NotNull
    private Integer nuBancoDestinatario;

    @Digits(integer = 15, fraction = 2, message = "quantidade tamanho permitido: 999999999999999")
    @NotNull
    private BigDecimal valor;

    @Override
    public String toString() {
        return "DepositWalletRequestDTO{" +
                "nuContaRemetente='" + nuContaRemetente + '\'' +
                ", cpfCnpjRemetente='" + cpfCnpjRemetente + '\'' +
                ", nuAgenciaRementente=" + nuAgenciaRementente +
                ", nuBancoRemetente=" + nuBancoRemetente +
                ", nmDestinatario='" + nmDestinatario + '\'' +
                ", nuContaDestinatario='" + nuContaDestinatario + '\'' +
                ", cpfCnpjDestinatario='" + cpfCnpjDestinatario + '\'' +
                ", nuAgenciaDestinatario=" + nuAgenciaDestinatario +
                ", nuBancoDestinatario=" + nuBancoDestinatario +
                ", valor=" + valor +
                '}';
    }
}

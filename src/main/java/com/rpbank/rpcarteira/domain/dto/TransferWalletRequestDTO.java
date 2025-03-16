package com.rpbank.rpcarteira.domain.dto;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class TransferWalletRequestDTO {

    @NotBlank(message = "nuContaRemetente não pode ser vazio")
    private String nuContaRemetente;

    @NotBlank(message = "contaDestinatario não pode ser vazio")
    private String nuContaDestinatario;

    @Digits(integer = 15, fraction = 2, message = "quantidade tamanho permitido: 999999999999999")
    @NotNull
    private BigDecimal valor;

    @Override
    public String toString() {
        return "TransferWalletRequestDTO{" +
                "nuContaRemetente='" + nuContaRemetente + '\'' +
                ", nuContaDestinatario='" + nuContaDestinatario + '\'' +
                ", valor=" + valor +
                '}';
    }
}

package com.rpbank.rpcarteira.domain.dto;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class WithdrawalWalletRequestDTO {

    @NotBlank(message = "nuConta não pode ser vazio")
    private String nuConta;

    @Digits(integer = 15, fraction = 2, message = "quantidade tamanho permitido: 999999999999999")
    @NotNull
    private BigDecimal valor;

    @Override
    public String toString() {
        return "WithdrawalWalletRequestDTO{" +
                "nuConta='" + nuConta + '\'' +
                ", valor=" + valor +
                '}';
    }
}

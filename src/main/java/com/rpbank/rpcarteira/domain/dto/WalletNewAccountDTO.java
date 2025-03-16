package com.rpbank.rpcarteira.domain.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Builder
public class WalletNewAccountDTO {

    private String nmPessoa;
    private String cpfPessoa;
    private String rgPessoa;
    private Integer tpConta;



    @Override
    public String toString() {
        return "WalletNewAccountDTO{" +
                "nmPessoa='" + nmPessoa + '\'' +
                ", cpfPessoa='" + cpfPessoa + '\'' +
                ", rgPessoa='" + rgPessoa + '\'' +
                ", tpConta='" + tpConta + '\'' +
                '}';
    }
}


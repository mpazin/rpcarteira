package com.rpbank.rpcarteira.domain.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
public class WalletRequestDTO {

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 100, message = "Máximo de caracteres para nome é {max}")
    private String nmPessoa;

    @NotBlank(message = "CPF não pode ser vazio")
    @Size(max = 11, message = "Máximo de caracteres para CPF é {max}")
    private String cpfPessoa;

    @NotBlank(message = "RG não pode ser vazio")
    private String rgPessoa;

    @NotBlank(message = "Informe o tipo de conta")
    @Size(max = 1, message = "Máximo de caracteres para Tipo Conta é {max}")
    private String tpConta;


    @Override
    public String toString() {
        return "WalletRequestDTO{" +
                "nmPessoa='" + nmPessoa + '\'' +
                ", cpfPessoa='" + cpfPessoa + '\'' +
                ", rgPessoa='" + rgPessoa + '\'' +
                ", tpConta='" + tpConta + '\'' +
                '}';
    }
}


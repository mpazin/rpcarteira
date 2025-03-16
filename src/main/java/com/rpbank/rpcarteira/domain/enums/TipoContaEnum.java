package com.rpbank.rpcarteira.domain.enums;

import com.rpbank.rpcarteira.exception.WalletException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TipoContaEnum {

    CONTA_CORRENTE(1,"C", "Conta Corrente"),
    CONTA_POUPANCA(2,"P", "Conta Poupança");

    private final Integer tpConta;
    private final String siglaConta;
    private final String descricao;

    public static TipoContaEnum getTipoContaBySigla(String sigla){
        return Arrays.stream(values()).filter( t -> t.siglaConta.equals(sigla))
                .findFirst()
                .orElseThrow(()->new WalletException(ErrorCodeEnum.TIPO_CONTA_NOT_FOUND));
    }
}

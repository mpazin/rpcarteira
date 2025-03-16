package com.rpbank.rpcarteira.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCodeEnum {
    TIPO_CONTA_NOT_FOUND(HttpStatus.NO_CONTENT, "TIPO_CONTA_NOT_FOUND", "Sigla para o tipo de conta é invalido."),
    ERROR_REGISTERING_NEW_ACCOUNT(HttpStatus.BAD_REQUEST, "ERROR_REGISTERING_NEW_ACCOUNT", "Não foi possivel criar a conta. Verifique os dados informados."),
    ERROR_GET_WALLET_BALANCE(HttpStatus.BAD_REQUEST, "ERROR_GET_WALLET_BALANCE", "Não foi consultar o saldo no momento."),
    WALLET_DOES_NOT_EXIST(HttpStatus.NO_CONTENT, "WALLET_DOES_NOT_EXIST", "Carteira inexiste ou número de conta corrente informado esta incorreto."),
    ERROR_DEPOSIT(HttpStatus.BAD_REQUEST, "ERROR_DEPOSIT", "Não foi possivel efetuar o deposito."),
    ERROR_WITHDRAWAL(HttpStatus.BAD_REQUEST, "ERROR_WITHDRAWAL", "Não foi possivel efetuar o saque."),
    ERROR_TRANSFER(HttpStatus.BAD_REQUEST, "ERROR_TRANSFER", "Não foi possivel efetuar a transferencia."),
    ERROR_GET_BALANCE_HISTORY(HttpStatus.BAD_REQUEST, "ERROR_GET_BALANCE_HISTORY", "Não foi possivel consultar o historico de saldo.")
    ;

    private final HttpStatus httpStatus;
    private final String nmReason;
    private final String dsError;
}

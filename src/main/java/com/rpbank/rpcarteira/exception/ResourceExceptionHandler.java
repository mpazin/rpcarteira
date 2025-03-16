package com.rpbank.rpcarteira.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResourceExceptionHandler {

    @ExceptionHandler({WalletException.class})
    public ResponseEntity<Object> walletException(WalletException exception) {
        return ResponseEntity.status(exception.getErrorCodeEnum().getHttpStatus())
                .body(exception.getErrorCodeEnum().getNmReason()+" - "+exception.getErrorCodeEnum().getDsError() );
    }


}

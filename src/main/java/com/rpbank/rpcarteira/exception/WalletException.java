package com.rpbank.rpcarteira.exception;

import ch.qos.logback.core.util.StringUtil;
import com.rpbank.rpcarteira.domain.enums.ErrorCodeEnum;
import com.rpbank.rpcarteira.util.StringUtils;
import lombok.Getter;

@Getter
public class WalletException extends RuntimeException {

    private final ErrorCodeEnum errorCodeEnum;
    private final String[] params;
    private final String message;

    public WalletException(ErrorCodeEnum errorCodeEnum) {

        this.errorCodeEnum = errorCodeEnum;
        this.params = null;
        this.message = null;
    }

    public WalletException(ErrorCodeEnum errorCodeEnum, String... params) {

        this.errorCodeEnum = errorCodeEnum;
        this.params = params;
        this.message = StringUtils.replaceString(errorCodeEnum.getDsError(), params);
    }
}

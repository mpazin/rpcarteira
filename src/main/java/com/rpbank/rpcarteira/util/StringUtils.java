package com.rpbank.rpcarteira.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class StringUtils {

    public String replaceString(String text, String... args){
        if(args == null){
            return text;
        }

        return Arrays.stream(args)
                .reduce(text, (subtotal, element) -> subtotal.replaceFirst("\\{}", element))
                .replace("\""," ");
    }
}

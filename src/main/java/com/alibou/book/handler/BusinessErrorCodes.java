package com.alibou.book.handler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@
public enum BusinessErrorCodes {

    private final int code;
    private final String description;
    private final HttpStatus httpStatus;
}

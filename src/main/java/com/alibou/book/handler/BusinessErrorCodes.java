package com.alibou.book.handler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;


public enum BusinessErrorCodes {

    // Error codes
    NO_CODE(0, HttpStatus.NOT_IMPLEMENTED, "No code"),

    INCORRECT_CURRENT_PASSWORD(300, BAD_REQUEST, "Current password is incorrect"),

    NEW_PASSWORD_DOES_NOT_MATCH(301, BAD_REQUEST, "The new password does not match"),

    ACCOUNT_LOCKED(302, FORBIDDEN, "User Account is Locked"),

    ACCOUNT_DISABLED(303, FORBIDDEN, "User account is Disabled"),
    BAD_CREDENTIALS(304, FORBIDDEN, "Login and / password is incorrect"),;




    @Getter
    private final int code;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus httpStatus, String description){
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}

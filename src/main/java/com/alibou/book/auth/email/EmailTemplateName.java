package com.alibou.book.auth.email;

import lombok.Data;
import lombok.Getter;

@Getter
public enum EmailTemplateName {

    ACTIVATE_ACCOUNT("account_activation");
    private final String name;

    EmailTemplateName(String name){
        this.name = name;
    }
}

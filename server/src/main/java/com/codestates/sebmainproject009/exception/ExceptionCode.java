package com.codestates.sebmainproject009.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member exists"),

    NOT_FOUND(500, "The requested access is invalid."),
    NOT_IMPLEMENTATION(501, "Not Implementation");
    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
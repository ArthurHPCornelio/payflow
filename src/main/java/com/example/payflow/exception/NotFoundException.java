package com.example.payflow.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class NotFoundException extends BaseException {
    public NotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }
}

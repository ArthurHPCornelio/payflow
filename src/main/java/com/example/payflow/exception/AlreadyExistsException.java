package com.example.payflow.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class AlreadyExistsException extends BaseException {
    public AlreadyExistsException(String message, String errorCode) {
        super(message, errorCode);
    }
}

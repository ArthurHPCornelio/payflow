package com.example.payflow.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(force = true)
@Data
public class BaseException extends RuntimeException {
    private final String errorCode;
    public BaseException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

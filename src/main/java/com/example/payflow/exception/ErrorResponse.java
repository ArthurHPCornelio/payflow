package com.example.payflow.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String errorCode;
    private String message;
    private HttpStatus status;
    private Instant timestamp;
    private String path;

    public static ErrorResponse create(Exception ex, HttpServletRequest request, HttpStatus status, String errorCode){
        return ErrorResponse.builder()
                .message(ex.getMessage())
                .errorCode(errorCode)
                .status(status)
                .timestamp(Instant.now())
                .path(request.getRequestURI())
                .build();
    }
}

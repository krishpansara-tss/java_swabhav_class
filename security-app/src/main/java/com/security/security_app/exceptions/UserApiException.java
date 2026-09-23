package com.security.security_app.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class UserApiException extends RuntimeException {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();

    public UserApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


}

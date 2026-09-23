package com.security.security_app.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class RegistrationDto {
    private String userName;
    private String password;
    private String role;
}

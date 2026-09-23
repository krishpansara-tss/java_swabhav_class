package com.security.security_app.dtos;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class LoginDto {
    private String userName;
    private String password;
}

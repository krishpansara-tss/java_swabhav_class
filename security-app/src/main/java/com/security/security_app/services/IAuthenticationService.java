package com.security.security_app.services;

import com.security.security_app.dtos.LoginDto;
import com.security.security_app.dtos.RegistrationDto;
import com.security.security_app.dtos.UserResponseDto;

public interface IAuthenticationService {
    UserResponseDto register(RegistrationDto dto);
    String login(LoginDto dto);
}

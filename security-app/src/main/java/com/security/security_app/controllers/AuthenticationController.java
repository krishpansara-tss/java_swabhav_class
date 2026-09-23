package com.security.security_app.controllers;

import com.security.security_app.dtos.LoginDto;
import com.security.security_app.dtos.RegistrationDto;
import com.security.security_app.dtos.UserResponseDto;
import com.security.security_app.services.IAuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthenticationController {
    private final IAuthenticationServiceImpl authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(RegistrationDto dto){
        System.out.println("00000000000000000000000000000000000000000000000000000000000000000000 " + dto);
        UserResponseDto response = authenticationService.register(dto);
        System.out.println("11111111111111111111111111111111111111111111111111111111111111111111 " + response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(LoginDto dto){
        String response = authenticationService.login(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

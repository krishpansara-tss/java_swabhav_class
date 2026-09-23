package com.security.security_app.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class JwtResponseDto {
    private String accessToken;
    private String accessType;
}

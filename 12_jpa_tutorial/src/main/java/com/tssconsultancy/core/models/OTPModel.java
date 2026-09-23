package com.tssconsultancy.core.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
@Entity
@Table(name ="otps")
public class OTPModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long otpId;
    private String email;
    private Integer cnt = 1;
    private LocalDateTime createdAt = LocalDateTime.now();
    private boolean used = false;
    private LocalDateTime expiryTime;

    private String verificationCode;
}

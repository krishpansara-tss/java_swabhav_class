package com.tssconsultancy.core.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OTPService {
    public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}

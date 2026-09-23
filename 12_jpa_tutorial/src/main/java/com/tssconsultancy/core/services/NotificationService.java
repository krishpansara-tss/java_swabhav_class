package com.tssconsultancy.core.services;

public interface NotificationService {
    void sendMessage(String receiver, String message);

    void verifyOtp(String email, String otp);

    void sendOtp(String email);
}

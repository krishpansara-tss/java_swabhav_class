package com.tssconsultancy.core.services;

import org.springframework.stereotype.Service;

@Service("whatsapp")
public class WhatsAppNotifier implements NotificationService {
    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println("Receiver : " + receiver + " | Message (Sent ON WhatsApp) : " + message);
    }

    @Override
    public void verifyOtp(String email, String otp) {

    }

    @Override
    public void sendOtp(String email) {

    }
}
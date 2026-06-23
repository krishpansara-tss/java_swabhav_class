package com.dipviolation;

public class EmergencyAlertService {

    private final EmailAlertSender alertSender;

    public EmergencyAlertService(EmailAlertSender alertSender) {
        this.alertSender = alertSender;
    }

    public void sendEmergencyAlert(String recipient, String message) {
        alertSender.sendAlert(recipient, message);
    }
}

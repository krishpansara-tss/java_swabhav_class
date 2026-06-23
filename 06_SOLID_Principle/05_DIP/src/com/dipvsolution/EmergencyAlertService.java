package com.dipvsolution;

public class EmergencyAlertService {
    private final AlertSender alertSender;

    public EmergencyAlertService(AlertSender alertSender) {
        this.alertSender = alertSender;
    }

    public void sendEmergencyAlert(String recipient, String message) {
        this.alertSender.sendAlert(recipient, message);
    }
}

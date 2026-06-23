package com.dipviolation;

public class EmailAlertSender {
    public void sendAlert(String recipient, String message) {
        System.out.println("[Email] Sending alert to " + recipient + ": " + message);
    }
}

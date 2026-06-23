package com.dipvsolution;

public class SmsAlertSender implements AlertSender {
    @Override
    public void sendAlert(String recipient, String message) {
        System.out.println("[SMS] sending to: " + recipient + " message: "+message);
    }
}

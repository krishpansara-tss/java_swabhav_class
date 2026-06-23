package com.dipvsolution;

public class EmailSender implements AlertSender {
    @Override
    public void sendAlert(String recipient, String message) {
        System.out.println("[EMAIL] sending to: " + recipient + " message: "+message);
    }
}

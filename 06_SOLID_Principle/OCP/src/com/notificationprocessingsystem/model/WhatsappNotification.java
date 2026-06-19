package com.notificationprocessingsystem.model;

import com.notificationprocessingsystem.interfaces.Notifications;

public class WhatsappNotification implements Notifications {
    @Override
    public void validate(NotificationRequest request) {
        if (request.getContact().length() != 10) {
            throw new RuntimeException("Invalid WhatsApp number");
        }
    }

    @Override
    public String formatMessage(NotificationRequest request) {
        return "Whatsapp: " + request.getMessage();
    }

    @Override
    public String send(NotificationRequest request) {
        return "Whatsapp massage sent: " + request.getContact();
    }
}

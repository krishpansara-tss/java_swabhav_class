package com.notificationprocessingsystem.model;

import com.notificationprocessingsystem.interfaces.Notifications;

public class PushNotification implements Notifications {
    @Override
    public void validate(NotificationRequest request) {
        if (request.getCustomerName().isEmpty() || request.getCustomerName() == null) {
            throw new RuntimeException("Invalid device token");
        }
    }

    @Override
    public String formatMessage(NotificationRequest request) {
        return "PUSH: " + request.getMessage();
    }

    @Override
    public String send(NotificationRequest request) {
        return "Push notification sent: "+ request.getContact();
    }
}

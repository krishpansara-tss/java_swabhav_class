package com.notificationprocessingsystem.model;

import com.notificationprocessingsystem.interfaces.Notifications;

public class SmsNotification implements Notifications {
    @Override
    public void validate(NotificationRequest request) {
        if(request.getContact().isEmpty() || request.getContact() == null){
            throw new IllegalArgumentException("Contact number can't be empty");
        }
    }

    @Override
    public String formatMessage(NotificationRequest request) {
        return "SMS: " + request.getMessage();
    }

    @Override
    public String send(NotificationRequest request) {
        return "SMS sent: " + request.getContact();
    }
}

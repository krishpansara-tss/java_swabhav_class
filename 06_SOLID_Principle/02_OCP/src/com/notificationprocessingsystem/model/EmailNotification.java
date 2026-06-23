package com.notificationprocessingsystem.model;

import com.notificationprocessingsystem.interfaces.Notifications;

public class EmailNotification implements Notifications {
    @Override
    public void validate(NotificationRequest request) {
        if(request.getCustomerName().isEmpty() || request.getCustomerName() == null){
            throw new IllegalArgumentException("Name can't be null");
        }
    }

    @Override
    public String formatMessage(NotificationRequest request) {
        return "EMAIL: Dear " + request.getCustomerName() +
                ", " + request.getMessage();
    }

    @Override
    public String send(NotificationRequest request) {
        return "Email sent to " + request.getCustomerName();
    }
}

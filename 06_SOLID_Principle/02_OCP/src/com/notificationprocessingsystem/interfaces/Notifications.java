package com.notificationprocessingsystem.interfaces;

import com.notificationprocessingsystem.model.NotificationRequest;

public interface Notifications {
    void validate(NotificationRequest request);
    String formatMessage(NotificationRequest request);
    String send(NotificationRequest request);
}

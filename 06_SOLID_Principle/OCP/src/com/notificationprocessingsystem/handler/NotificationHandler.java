package com.notificationprocessingsystem.handler;

import com.notificationprocessingsystem.interfaces.Notifications;
import com.notificationprocessingsystem.model.NotificationRequest;
import com.notificationprocessingsystem.services.NotificationTypes;

public class NotificationHandler {
    public void processNotification(NotificationRequest request){
        try {
            Notifications notification = NotificationTypes.getNotification(request.getType());

            notification.validate(request);

            String message = notification.formatMessage(request);
            System.out.println(message);

            String status = notification.send(request);
            System.out.println(status);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}


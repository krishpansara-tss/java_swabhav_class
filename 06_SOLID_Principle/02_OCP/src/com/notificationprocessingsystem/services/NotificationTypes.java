package com.notificationprocessingsystem.services;

import com.notificationprocessingsystem.interfaces.Notifications;
import com.notificationprocessingsystem.model.EmailNotification;
import com.notificationprocessingsystem.model.PushNotification;
import com.notificationprocessingsystem.model.SmsNotification;
import com.notificationprocessingsystem.model.WhatsappNotification;

public class NotificationTypes {

        public static Notifications getNotification(String type) {

            switch (type.toLowerCase()) {
                case "email": return new EmailNotification();
                case "sms": return new SmsNotification();
                case "push": return new PushNotification();
                case "whatsapp": return new WhatsappNotification();
                default: throw new RuntimeException("Unsupported notification type");
            }
        }
    }

package com.notificationprocessingsystem;

import com.notificationprocessingsystem.model.NotificationRequest;
import com.notificationprocessingsystem.services.NotificationServices;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        NotificationServices service = new NotificationServices();

        NotificationRequest r1 = new NotificationRequest("Krish",
                "krish@gmail.com","email",
                "ORDER_PLACED",
                "Your order has been placed successfully!",
                "high",
                LocalDateTime.now()
        );

        NotificationRequest r2 = new NotificationRequest(
                "Raj",
                "9876543210",
                "sms",
                "PAYMENT_SUCCESS",
                "Payment received!",
                "normal",
                LocalDateTime.now()
        );

        NotificationRequest r3 = new NotificationRequest(
                "Amit",
                "device123",
                "push",
                "SHIPPED",
                "Your order is shipped!",
                "urgent",
                LocalDateTime.now()
        );

        NotificationRequest r4 = new NotificationRequest(
                "Neha",
                "9999999999",
                "whatsapp",
                "OFFER",
                "Special discount just for you!",
                "high",
                LocalDateTime.now()
        );

        service.addRequest(r1);
        service.addRequest(r2);
        service.addRequest(r3);
        service.addRequest(r4);

        service.processAll();
    }
}

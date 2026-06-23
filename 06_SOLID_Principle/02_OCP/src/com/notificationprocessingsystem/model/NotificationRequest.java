package com.notificationprocessingsystem.model;

import java.time.LocalDateTime;

public class NotificationRequest {
    private String customerName;
    private String contact;
    private String type;
    private String event;
    private String message;
    private String priority;
    private LocalDateTime timestamp;

    public NotificationRequest(String customerName, String contact, String type, String event, String message, String priority, LocalDateTime timestamp) {
        this.customerName = customerName;
        this.contact = contact;
        this.type = type;
        this.event = event;
        this.message = message;
        this.priority = priority;
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public String getEvent() {
        return event;
    }

    public String getPriority() {
        return priority;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContact() {
        return contact;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
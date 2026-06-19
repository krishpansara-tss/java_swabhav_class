package com.notificationprocessingsystem.services;

import com.notificationprocessingsystem.handler.NotificationHandler;
import com.notificationprocessingsystem.model.NotificationRequest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NotificationServices {
    private PriorityQueue<NotificationRequest> queue =
            new PriorityQueue<>(Comparator.comparing(NotificationRequest::getPriority));

    public void addRequest(NotificationRequest request) {
        queue.add(request);
    }

    public void processAll() {
        NotificationHandler processor = new NotificationHandler();

        while (!queue.isEmpty()) {
            processor.processNotification(queue.poll());
        }
    }
}

package com.smarthospital.model;

import com.smarthospital.interfaces.Loggable;

public class PortableGlucoseMeter extends Equipment implements Loggable {
    public PortableGlucoseMeter(String id, String name, String status) {
        super(id, name, status);
    }

    public void performGlucoseMeasurement() {
        System.out.println(getName() + ": Blood glucose read successfully.");
    }

    @Override
    public void activityLog(String operation) {
        System.out.printf("[LOG] ID: %s | Op: %s | Time: %tF %<tT%n", getId(), operation, java.time.LocalDateTime.now());
    }
}

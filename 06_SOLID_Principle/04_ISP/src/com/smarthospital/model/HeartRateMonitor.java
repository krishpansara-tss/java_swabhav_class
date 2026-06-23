package com.smarthospital.model;

import com.smarthospital.interfaces.Loggable;
import com.smarthospital.interfaces.Monitorable;
import com.smarthospital.interfaces.Transmittable;
import com.smarthospital.model.Equipment;

public class HeartRateMonitor extends Equipment implements Monitorable, Transmittable, Loggable {
    public HeartRateMonitor(String id, String name, String status) {
        super(id, name, status);
    }

    @Override
    public void startMonitoring() { System.out.println(getName() + " started heart rate tracking."); }
    @Override
    public void stopMonitoring() { System.out.println(getName() + " stopped tracking."); }

    @Override
    public void transmitData() { System.out.println("Sending data " + getName() + " to central server."); }

    @Override
    public void activityLog(String operation) {
        System.out.printf("[LOG] ID: %s | Op: %s | Time: %tF %<tT%n", getId(), operation, java.time.LocalDateTime.now());
    }

}
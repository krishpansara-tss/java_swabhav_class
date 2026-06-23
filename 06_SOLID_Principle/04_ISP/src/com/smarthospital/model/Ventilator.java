package com.smarthospital.model;

import com.smarthospital.interfaces.Alertable;
import com.smarthospital.interfaces.Loggable;
import com.smarthospital.interfaces.Maintainable;
import com.smarthospital.interfaces.Monitorable;

public class Ventilator extends Equipment implements Monitorable, Alertable, Maintainable, Loggable {
    public Ventilator(String id, String name, String status) {
        super(id, name, status);
    }

    @Override
    public void startMonitoring() { System.out.println(getName() + " monitoring started"); }
    @Override
    public void stopMonitoring() { System.out.println(getName() + " monitoring stopped."); }

    @Override
    public void triggerAlert(String message) {
        System.out.printf("[ALERT] Equipment ID: %s (%s) flags: %s%n", getId(), getName(), message);
    }

    @Override
    public void performMaintenanceCheck(String date) {
        System.out.printf("[MAINTENANCE] Maintenance checking for ID: %s.%n", getId());
    }

    @Override
    public void activityLog(String operation) {
        System.out.printf("[LOG] ID: %s | Op: %s | Time: %tF %<tT%n", getId(), operation, java.time.LocalDateTime.now());
    }
}

package com.smarthospital.model;

import com.smarthospital.interfaces.Calibratable;
import com.smarthospital.interfaces.Diagnosable;
import com.smarthospital.interfaces.Loggable;

public class MRIMachine extends Equipment implements Diagnosable, Calibratable, Loggable {
    public MRIMachine(String id, String name, String status) {
        super(id, name, status);
    }

    @Override
    public void generateDiagnosticReport() { System.out.println("Generating generate Diagnostic Report from " + getName() + "."); }

    @Override
    public void calibrate() { System.out.println("Calibrating " + getName() + "."); }

    @Override
    public void activityLog(String operation) {
        System.out.printf("[LOG] ID: %s | Op: %s | Time: %tF %<tT%n", getId(), operation, java.time.LocalDateTime.now());
    }
}

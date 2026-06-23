package com.smarthospital.model;

import com.smarthospital.interfaces.Calibratable;
import com.smarthospital.interfaces.Diagnosable;
import com.smarthospital.interfaces.Loggable;
import com.smarthospital.interfaces.Transmittable;

public class LaboratoryAnalyzer extends Equipment implements Diagnosable, Calibratable, Transmittable, Loggable {
    public LaboratoryAnalyzer(String id, String name, String status) {
        super(id, name, status);
    }

    public void analyzeMedicalSample() { System.out.println(getName() + " is evaluating blood sample."); }

    @Override
    public void generateDiagnosticReport() { System.out.println("Generating blood report via " + getName() + "."); }

    @Override
    public void calibrate() { System.out.println("Calibrating: " + getName() + "."); }

    @Override
    public void transmitData() { System.out.println("Transmitting data to central server."); }

    @Override
    public void activityLog(String operation) {
        System.out.printf("[LOG] ID: %s | Op: %s | Time: %tF %<tT%n", getId(), operation, java.time.LocalDateTime.now());
    }
}

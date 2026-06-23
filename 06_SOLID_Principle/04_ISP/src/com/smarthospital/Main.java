package com.smarthospital;

import com.smarthospital.model.HeartRateMonitor;
import com.smarthospital.model.MRIMachine;
import com.smarthospital.model.Ventilator;

public class Main {
    public static void main(String[] args) {
        HeartRateMonitor hrm = new HeartRateMonitor("HRM-001", "Monitor", "Active");
        MRIMachine mri = new MRIMachine("MRI-001", "MRI", "Calibrating");
        Ventilator vent = new Ventilator("VENT-001", "Ventilator", "Critical-Use");

        System.out.println("--- 1. Core Equipment Status ---");
        hrm.displayStatus();
        mri.displayStatus();
        vent.displayStatus();

        System.out.println("\n--- 2. Operations (ISP Verified) ---");
        hrm.startMonitoring();
        hrm.transmitData();
        hrm.activityLog("Data Upload Completed");

        mri.calibrate();
        mri.generateDiagnosticReport();

        vent.startMonitoring();
        vent.triggerAlert("Something happen!");
        vent.performMaintenanceCheck("2026-06-22");
    }
}
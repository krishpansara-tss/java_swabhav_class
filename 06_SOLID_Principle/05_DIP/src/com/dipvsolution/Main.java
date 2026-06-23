package com.dipvsolution;

import com.dipviolation.EmailAlertSender;

public class Main {
    public static void main(String[] args) {
        String alertMessage = "Hey there!!";

        // --- Scenario A: Sending via Email ---
        AlertSender emailDetails = new EmailSender();
        EmergencyAlertService emailService = new EmergencyAlertService(emailDetails);
        emailService.sendEmergencyAlert("x@gml.com", alertMessage);

        System.out.println("----------------------------------------");

        // --- Scenario B: Sending via SMS (No changes needed to EmergencyAlertService) ---
        AlertSender smsDetails = new SmsAlertSender();
        EmergencyAlertService smsService = new EmergencyAlertService(smsDetails);
        smsService.sendEmergencyAlert("9898989898", alertMessage);
    }
}

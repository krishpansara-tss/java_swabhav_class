package com.dipviolation;

public class Main {
    public static void main(String[] args) {
        String message = "Alert";

        EmailAlertSender emailSender = new EmailAlertSender();
        EmergencyAlertService emailService = new EmergencyAlertService(emailSender);
        emailService.sendEmergencyAlert("x@gml.com", message);


//        AlertSender smsSender = new SmsAlertSender();
//        EmergencyAlertService smsService = new EmergencyAlertService(smsSender);
//        smsService.sendEmergencyAlert("+1234567890", message);
    }
}

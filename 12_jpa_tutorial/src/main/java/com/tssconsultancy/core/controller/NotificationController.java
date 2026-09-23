package com.tssconsultancy.core.controller;

import com.tssconsultancy.core.services.NotificationProcessor;
import com.tssconsultancy.core.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationProcessor notificationProcessor;

    @GetMapping("/notify")
    public void sendMessage(@RequestParam String receiver, @RequestParam String message, @RequestParam String type){
        NotificationService notificationService = notificationProcessor.getProcessor(type);
        notificationService.sendMessage(receiver, message);
    }

    @GetMapping("/send-otp/email")
    public void sendMessage(@RequestParam String email){
        System.out.println("email : " + email);
        NotificationService notificationService = notificationProcessor.getProcessor("email");
        notificationService.sendOtp(email);
    }

    @GetMapping("/verify-otp/email")
    public void sendMessage(@RequestParam String email, @RequestParam String otp){
        NotificationService notificationService = notificationProcessor.getProcessor("email");
        notificationService.verifyOtp(email, otp);
    }
}

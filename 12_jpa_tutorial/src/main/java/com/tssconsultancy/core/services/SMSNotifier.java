package com.tssconsultancy.core.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotifier implements NotificationService {
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    @Override
    public void verifyOtp(String email, String otp) {

    }

    @Override
    public void sendOtp(String email) {

    }

    @PostConstruct
    public void initTwilio() {
        System.out.println("Initializing Twilio with SID: " + accountSid);
        Twilio.init(accountSid, authToken);
    }

    @Override
    public void sendMessage(String to, String messageToSend) {
        System.out.println("number: "+to);
        Message message = Message.creator(
                new PhoneNumber("+91" + to), // To number
                new PhoneNumber(fromPhoneNumber), // From Twilio number
                messageToSend
        ).create();
        System.out.println("Receiver : " + to + " | Message (Sent ON SMS) : " + message);
    }
}

package com.tss.kafka_demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "myTopic", groupId = "myGroup")
    public void consume(String message){
        System.out.println("Consumed message : " + message);
    }
}

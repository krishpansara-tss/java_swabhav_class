package com.tss.kafka_demo.service;

//import ;

import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerService {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ProducerService.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        logger.info("Message sent: {}", message);
        System.out.println(message);
    }
}

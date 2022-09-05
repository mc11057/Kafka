package com.visionydesarrollo.kafkaservice.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PublishTransaction {


    private KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC_NAME="test";

    public PublishTransaction(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(String msg) {
        kafkaTemplate.send(TOPIC_NAME, msg);
    }
}

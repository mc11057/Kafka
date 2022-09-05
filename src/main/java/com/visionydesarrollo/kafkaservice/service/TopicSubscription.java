package com.visionydesarrollo.kafkaservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visionydesarrollo.kafkaservice.entity.Transaction;
import com.visionydesarrollo.kafkaservice.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class TopicSubscription {

    private final String TOPIC_NAME="test";
    private final TransactionRepository transactionRepository;
    private static Logger logger = LoggerFactory.getLogger(TopicSubscription.class);

    public TopicSubscription(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @KafkaListener(topics = TOPIC_NAME, groupId = "group-id")
    public void listen(String transactionMessage) throws JsonProcessingException {
        logger.info("New transaction received.Transaction: {}",transactionMessage);
        Transaction transaction = new ObjectMapper().readValue(transactionMessage, Transaction.class);
        transactionRepository.save(transaction);
    }
}

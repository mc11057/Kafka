package com.visionydesarrollo.kafkaservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.visionydesarrollo.kafkaservice.entity.Transaction;
import com.visionydesarrollo.kafkaservice.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionHandler implements TransactionService{
    private final PublishTransaction publishTransaction;
    private final TransactionRepository transactionRepository;


    public TransactionHandler(PublishTransaction publishTransaction, TransactionRepository transactionRepository) {
        this.publishTransaction = publishTransaction;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void createTransaction(Transaction transaction) throws JsonProcessingException {
        //publishing transaction
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonMessage = ow.writeValueAsString(transaction);
        publishTransaction.publish(jsonMessage);
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }
}

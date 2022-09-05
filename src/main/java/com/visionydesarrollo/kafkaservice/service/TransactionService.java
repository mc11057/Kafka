package com.visionydesarrollo.kafkaservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.visionydesarrollo.kafkaservice.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public void handleNewTransaction(Transaction transaction) throws JsonProcessingException;
    public List <Transaction> getAll();
}

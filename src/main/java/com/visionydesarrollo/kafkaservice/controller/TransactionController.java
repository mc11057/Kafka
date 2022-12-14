package com.visionydesarrollo.kafkaservice.controller;

import com.visionydesarrollo.kafkaservice.entity.Transaction;
import com.visionydesarrollo.kafkaservice.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @CrossOrigin
    @PostMapping()
    public ResponseEntity publishTransaction(@RequestBody Transaction transaction)
    {
        try{
            transactionService.createTransaction(transaction);
            return new ResponseEntity<>("Message published and sent", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @CrossOrigin
    @GetMapping
    public ResponseEntity getAllTransactions(){
        try{
            List<Transaction> transactionList = transactionService.getAll();
            return new ResponseEntity<>(transactionList,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

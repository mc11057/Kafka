package com.visionydesarrollo.kafkaservice.repository;

import com.visionydesarrollo.kafkaservice.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

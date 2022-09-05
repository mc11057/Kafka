package com.visionydesarrollo.kafkaservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="client_name", length=100)
    private String clientName;
    @Column(name = "total_amount",scale = 2, precision = 10)
    private BigDecimal totalAmount;

    public Transaction(String clientName, BigDecimal totalAmount) {
        this.clientName = clientName;
        this.totalAmount = totalAmount;
    }

    public Transaction() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}

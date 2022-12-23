package com.microservices.currencyconversionservice.model;

import java.math.BigDecimal;

public class CurrencyConversion {
    private String id;
    private String from;
    private String to;
    private BigDecimal conversion;
    private BigDecimal quantity;
    private BigDecimal totalAmount;
    private String environnement;


    public CurrencyConversion() {
    }

    public CurrencyConversion(String id, String from, String to,  BigDecimal quantity, BigDecimal conversion, BigDecimal totalAmount, String environnement) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversion = conversion;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.environnement = environnement;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversion() {
        return this.conversion;
    }

    public void setConversion(BigDecimal conversion) {
        this.conversion = conversion;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getEnvironnement() {
        return this.environnement;
    }

    public void setEnvironnement(String environnement) {
        this.environnement = environnement;
    }

}

package com.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
    CurrencyExchange findByFromAndTo(String from, String to);
}

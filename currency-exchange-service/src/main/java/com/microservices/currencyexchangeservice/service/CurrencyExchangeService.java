package com.microservices.currencyexchangeservice.service;

import java.math.BigDecimal;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.microservices.currencyexchangeservice.model.dto.CreateCurrencyExchangeDto;

public interface CurrencyExchangeService {
    
    CurrencyExchange getCurrencyExchange(String from, String to) throws NotFoundException;

    CurrencyExchange createCurrencyExchange(CreateCurrencyExchangeDto createCurrencyExchangeDto) throws NotFoundException;

}

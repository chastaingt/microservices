package com.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.microservices.currencyexchangeservice.model.dto.CreateCurrencyExchangeDto;
import com.microservices.currencyexchangeservice.service.CurrencyExchangeService;

@RestController
@RequestMapping("/api/v1/currency-exchange")
public class CurrencyExchangeController {


    private final CurrencyExchangeService currencyExchangeService;
    
    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }
    
    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) throws NotFoundException {
        return currencyExchangeService.getCurrencyExchange(from, to);
    }

    @PostMapping("")
    public CurrencyExchange createExchangeValue(@RequestBody CreateCurrencyExchangeDto createCurrencyExchangeDto) throws NotFoundException {
        return currencyExchangeService.createCurrencyExchange(createCurrencyExchangeDto);
    }
}

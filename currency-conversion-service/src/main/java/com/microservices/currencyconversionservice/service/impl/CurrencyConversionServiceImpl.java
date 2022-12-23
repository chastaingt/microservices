package com.microservices.currencyconversionservice.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.currencyconversionservice.model.CurrencyConversion;
import com.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import com.microservices.currencyconversionservice.service.CurrencyConversionService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @Override
    public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity("http://localhost:8000/api/v1/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion = response.getBody();
        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversion(), quantity.multiply(currencyConversion.getConversion()), currencyConversion.getEnvironnement());
    
    }

    @Override
    public CurrencyConversion calculateCurrencyConversionFeign(String from, String to, BigDecimal quantity) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchange(from, to);
        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversion(), quantity.multiply(currencyConversion.getConversion()), currencyConversion.getEnvironnement());
    
    }
    
}

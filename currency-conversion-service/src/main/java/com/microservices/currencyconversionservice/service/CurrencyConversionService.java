package com.microservices.currencyconversionservice.service;

import java.math.BigDecimal;

import com.microservices.currencyconversionservice.model.CurrencyConversion;

public interface CurrencyConversionService {
    CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity);
    CurrencyConversion calculateCurrencyConversionFeign(String from, String to, BigDecimal quantity);

}

package com.microservices.currencyconversionservice.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.currencyconversionservice.model.CurrencyConversion;

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/api/v1/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchange(@PathVariable String from, @PathVariable String to);
}

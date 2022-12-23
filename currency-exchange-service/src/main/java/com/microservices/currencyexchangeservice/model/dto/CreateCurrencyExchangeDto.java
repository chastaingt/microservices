package com.microservices.currencyexchangeservice.model.dto;

import java.math.BigDecimal;

public class CreateCurrencyExchangeDto {

    public String from;
    public String to;
    public BigDecimal conversion;

}

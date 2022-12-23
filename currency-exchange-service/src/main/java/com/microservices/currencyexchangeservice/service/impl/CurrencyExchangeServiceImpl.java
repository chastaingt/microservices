package com.microservices.currencyexchangeservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.microservices.currencyexchangeservice.model.dto.CreateCurrencyExchangeDto;
import com.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.microservices.currencyexchangeservice.service.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{

    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;
    
    @Override
    public CurrencyExchange getCurrencyExchange(String from, String to) throws NotFoundException {

        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        if(currencyExchange == null) {
            throw new NotFoundException();
        }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironnement(port);
        return currencyExchange;
    }

    @Override
    public CurrencyExchange createCurrencyExchange(CreateCurrencyExchangeDto createCurrencyExchangeDto){
                CurrencyExchange currencyExchange = repository.findByFromAndTo(createCurrencyExchangeDto.from, createCurrencyExchangeDto.to);
                if(currencyExchange != null) {
                    throw new InternalError();
                }
                CurrencyExchange currencyExchangeToCreate = new CurrencyExchange(UUID.randomUUID().toString(), createCurrencyExchangeDto.from, createCurrencyExchangeDto.to, createCurrencyExchangeDto.conversion);
                return repository.save(currencyExchangeToCreate);
    }
    
}

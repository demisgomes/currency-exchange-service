package com.course.microservices.currencyexchangeservice.services;

import com.course.microservices.currencyexchangeservice.domain.ExchangeValue;
import com.course.microservices.currencyexchangeservice.repositories.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueService {
    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    public ExchangeValue retrieveCurrencyFromAndTo(String from, String to){
        return exchangeValueRepository.findByFromAndTo(from,to);
    }
}

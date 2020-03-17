package com.course.microservices.currencyexchangeservice.controllers;

import com.course.microservices.currencyexchangeservice.domain.ExchangeValue;
import com.course.microservices.currencyexchangeservice.services.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueService exchangeValueService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = exchangeValueService.retrieveCurrencyFromAndTo(from, to);
        exchangeValue.setPort(
                Integer.parseInt(
                        Objects.requireNonNull(environment.getProperty("local.server.port"))
                ));
        return exchangeValue;
    }
}

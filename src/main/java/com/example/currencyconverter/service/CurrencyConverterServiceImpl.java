package com.example.currencyconverter.service;

import com.example.currencyconverter.dto.CurrencyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

    private final CurrencyAPIService currencyAPIService;


    @Override
    public Double getCurrencyRate(String sendCountry, String receiveCountry) {
        CurrencyDto currency = currencyAPIService.getCurrency();
        String sendReceiveCountry = sendCountry + receiveCountry;
        Double convertedCurrency = currency.getQuotes().get(sendReceiveCountry);

        return convertedCurrency;
    }
}

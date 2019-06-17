package com.example.currencyconverter.service;

import com.example.currencyconverter.dto.CurrencyDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyConverterServiceImplTest {

    @Autowired
    CurrencyAPIService currencyAPIService;
    @Autowired
    CurrencyConverterService currencyConverterService;

    @Test
    public void 송금액_잘_가져왔는지_확인() {
        CurrencyDto currencies = currencyAPIService.getCurrency();
        Double currencyFromDirectAPI = currencies.getQuotes().get("USDPHP");
        Double currencyFromConverterService = currencyConverterService.getCurrencyRate("PHP");
        Assert.assertEquals(currencyFromDirectAPI, currencyFromConverterService);
    }
}
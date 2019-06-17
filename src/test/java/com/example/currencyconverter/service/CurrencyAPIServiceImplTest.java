package com.example.currencyconverter.service;

import com.example.currencyconverter.dto.CurrencyDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyAPIServiceImplTest {
    @Autowired
    private CurrencyAPIServiceImpl currencyAPIService;

    @Test
    public void currencyLayer_API로_환율정보_호출(){
        CurrencyDto currency = currencyAPIService.getCurrency();
        Assert.assertNotNull(currency);
    }

}
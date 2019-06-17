package com.example.currencyconverter.controller;

import com.example.currencyconverter.service.CurrencyConverterService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyConverterAPIControllerTest {
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private CurrencyConverterAPIController currencyConverterAPIController;

    @MockBean
    private CurrencyConverterService currencyConverterService;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getExchangeRate() throws Exception {
        String uri = "/api/exchange-rates?receiveCountry=LLLLL";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    public void 값을_잘_포맷하는지_확인() {
        String expectedValue = "1,114.30";
        Double rates = 1114.3;
        String formatTest = currencyConverterAPIController.format(rates);
        Assert.assertEquals(expectedValue, formatTest);
    }
}
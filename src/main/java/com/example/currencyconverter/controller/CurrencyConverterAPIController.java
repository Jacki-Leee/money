package com.example.currencyconverter.controller;

import com.example.currencyconverter.dto.ConvertDto;
import com.example.currencyconverter.service.CurrencyConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyConverterAPIController {
    private final CurrencyConverterService currencyConverter;
    private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    @GetMapping("/exchange-rates")
    public ResponseEntity getExchangeRate(@RequestBody ConvertDto convertDto){
        Double exchangeRate = currencyConverter.getCurrencyRate(convertDto.getSendCountry(), convertDto.getReceiveCountry());
        return new ResponseEntity(format(exchangeRate), HttpStatus.OK);
    }

    public String format(Number number){
        return decimalFormat.format(number);
    }
}

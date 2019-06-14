package com.example.currencyconverter.controller;

import com.example.currencyconverter.dto.ConvertInfoDto;
import com.example.currencyconverter.service.CurrencyConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyConverterAPIController {
    private final CurrencyConverterService currencyConverter;
    private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    @GetMapping("/exchange-rates")
    public ResponseEntity getExchangeRate(@RequestBody ConvertInfoDto convertInfo){
        Double exchangeRate = currencyConverter.getCurrencyRate(convertInfo.getSendCountry(), convertInfo.getReceiveCountry());
        return new ResponseEntity(format(exchangeRate), HttpStatus.OK);
    }

    @GetMapping("/send-amounts")
    public ResponseEntity getSendAmount(@RequestBody  ConvertInfoDto convertInfo){

        Double currency = currencyConverter.getCurrencyRate(convertInfo.getSendCountry(), convertInfo.getReceiveCountry());
        Double sendAmount = (currency * convertInfo.getSendAmount());
        String formatSendAmount = format(sendAmount);
        

        return new ResponseEntity(formatSendAmount, HttpStatus.OK);
    }

    public String format(Number number){
        return decimalFormat.format(number);
    }
}

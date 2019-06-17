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

    //국가에 따른 환율을 가져오는 메소드
    @GetMapping("/exchange-rates")
    public ResponseEntity getExchangeRate(@RequestParam(name = "receiveCountry") String receiveCountry){
        Double exchangeRate = currencyConverter.getCurrencyRate(receiveCountry);
        return new ResponseEntity(format(exchangeRate), HttpStatus.OK);
    }

    //송금액을 가져오는 메소드
    @PostMapping("/exchange-rates")
    public ResponseEntity getSendAmount(@RequestBody  ConvertInfoDto convertInfo){

        Double currency = currencyConverter.getCurrencyRate(convertInfo.getReceiveCountry());
        Double sendAmount = (currency * convertInfo.getSendAmount());
        String formatSendAmount = format(sendAmount);

        return new ResponseEntity(formatSendAmount, HttpStatus.OK);
    }

    public String format(Number number){
        return decimalFormat.format(number);
    }
}

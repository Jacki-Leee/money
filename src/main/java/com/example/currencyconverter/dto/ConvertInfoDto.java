package com.example.currencyconverter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvertInfoDto {
    private String receiveCountry;
    private double sendAmount;
}

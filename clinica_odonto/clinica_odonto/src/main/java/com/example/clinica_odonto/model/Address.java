package com.example.clinica_odonto.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private Integer id;
    private String street;
    private String number;
    private String city;
    private String state;
}

package com.example.clinica_odonto.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private Integer age;
    private Address address;
    private Integer addressId;

}

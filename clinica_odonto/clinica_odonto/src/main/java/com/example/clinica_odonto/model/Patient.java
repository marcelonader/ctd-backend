package com.example.clinica_odonto.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {
    private String name;
    private String lastname;
    private String email;
    private Integer age;

    public Patient(String name, String lastname, String email, Integer age) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

}

package com.example.clinica_odontologica_16_11_2021.model;

import com.example.clinica_odontologica_16_11_2021.dto.AddressDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private Integer id;
    private String street;
    private String number;


    public Address(AddressDTO addressDTO){
        this.id = addressDTO.getId();
        this.street = addressDTO.getStreet();
        this.number = addressDTO.getNumber();
    }
}

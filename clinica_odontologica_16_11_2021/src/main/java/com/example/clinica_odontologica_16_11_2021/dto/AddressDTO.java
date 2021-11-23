package com.example.clinica_odontologica_16_11_2021.dto;

import com.example.clinica_odontologica_16_11_2021.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Integer id;
    private String street;
    private String number;

    public AddressDTO(Address address){
        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNumber();
    }
}
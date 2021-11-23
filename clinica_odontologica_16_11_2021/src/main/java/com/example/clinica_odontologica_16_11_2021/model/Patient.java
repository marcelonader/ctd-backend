package com.example.clinica_odontologica_16_11_2021.model;

import com.example.clinica_odontologica_16_11_2021.dto.PatientDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {
    private Integer id;
    private String name;
    private String lastname;
    private Address address;
//    private Integer addressId;


    public Patient() {
    }

    public Patient(PatientDTO patientDTO, Address address) {
        this.id = patientDTO.getId();
        this.name = patientDTO.getName();
        this.lastname = patientDTO.getLastname();
        this.address = address;
    }
}

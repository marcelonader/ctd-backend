package com.example.clinica_odontologica_16_11_2021.dto;

import com.example.clinica_odontologica_16_11_2021.model.Address;
import com.example.clinica_odontologica_16_11_2021.model.Patient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {
    private Integer id;
    private String name;
    private String lastname;
//    private Address address;
    private Integer addressId;

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.lastname = patient.getLastname();
        this.addressId = patient.getAddress().getId();
    }
}

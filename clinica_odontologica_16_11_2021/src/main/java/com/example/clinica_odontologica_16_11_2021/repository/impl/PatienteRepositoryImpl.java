package com.example.clinica_odontologica_16_11_2021.repository.impl;

import com.example.clinica_odontologica_16_11_2021.dto.PatientDTO;
import com.example.clinica_odontologica_16_11_2021.model.Patient;
import com.example.clinica_odontologica_16_11_2021.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class PatienteRepositoryImpl implements IRepository<Patient> {

    private static Map<Integer, PatientDTO> patientDTOMap = new HashMap<>();
    private static Integer idG = 1;

    @Autowired
    private AddressRepositoryImpl addressRepository;

//    public PatienteRepositoryImpl() {
//        this.addressRepository = new AddressRepositoryImpl();
//    }

    @Override
    public Patient save(Patient patient) {

        patient.setAddress(addressRepository.save(patient.getAddress()));
        patient.setId(idG);

        PatientDTO patientDTO = new PatientDTO(patient);
        patientDTOMap.put(idG++, patientDTO);
        return patient;
    }

    @Override
    public Patient searchById(Integer id) {

        PatientDTO patientDTO = patientDTOMap.get(id);
        return new Patient(patientDTO, addressRepository.searchById(patientDTO.getAddressId()));
    }
}

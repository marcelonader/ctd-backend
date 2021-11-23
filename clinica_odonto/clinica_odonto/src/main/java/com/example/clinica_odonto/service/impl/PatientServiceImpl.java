package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Address;
import com.example.clinica_odonto.model.Patient;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements OdontoService<Patient> {
    private static Map<Integer, Patient> patientMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Autowired
    AddressServiceImpl addressService;

    @Override
    public Patient create(Patient patient) {
        patient.setAddressId(addressService.create(patient.getAddress()).getId());
        patient.setId(idGlobal);
        patientMap.put(idGlobal++, patient);
        return patient;
    }

    @Override
    public Map<Integer, Patient> listAll() {
        return patientMap;
    }

    @Override
    public void delete(Integer id) {
        patientMap.remove(id);
    }

    @Override
    public Patient search(Integer id) {
        Patient patient = patientMap.get(id);
        patient.setAddress(addressService.search(patient.getAddressId()));
        return patient;
    }

    @Override
    public Patient update(Patient patient) {
//        Patient patient = search(id);
//       patient.setName(name);
//       patient.setEmail(name.toLowerCase() + patient.getLastname().toLowerCase() + "@dh.com.br");
       return patient;
    }
}

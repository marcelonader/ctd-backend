package com.example.clinica_odontologica_16_11_2021.service.impl;

import com.example.clinica_odontologica_16_11_2021.model.Address;
import com.example.clinica_odontologica_16_11_2021.model.Patient;
import com.example.clinica_odontologica_16_11_2021.repository.impl.PatienteRepositoryImpl;
import com.example.clinica_odontologica_16_11_2021.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements OdontoService<Patient> {


    @Autowired
    PatienteRepositoryImpl patienteRepository;

    @Override
    public Patient save(Patient patient) {
        return patienteRepository.save(patient);
    }

    @Override
    public Patient searchById(Integer id) {
        return patienteRepository.searchById(id);
    }

}

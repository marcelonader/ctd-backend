package com.example.clinica_odontologica_16_11_2021.controller;

import com.example.clinica_odontologica_16_11_2021.model.Patient;
import com.example.clinica_odontologica_16_11_2021.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientServiceImpl patientService;

    @PostMapping
    public ResponseEntity<Patient> savePatiente(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.save(patient));
    }
}

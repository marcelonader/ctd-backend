package com.example.clinica_odonto.controller;

import com.example.clinica_odonto.model.Patient;
import com.example.clinica_odonto.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.create(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> searchPatients(@PathVariable Integer id){
        return ResponseEntity.ok(patientService.search(id));
    }
//
//    @GetMapping("delete/{id}")
//    public String deletePatient(@PathVariable Integer id){
//        patientService.delete(id);
//        return "Paciente deletado";
//    }
//
//    @GetMapping("search/{id}")
//    public Patient searchPatient(@PathVariable Integer id){
//        return patientService.search(id);
//    }
//
//    @GetMapping("update/{id}/{name}")
//    public Patient updatePatient(@PathVariable Integer id, @PathVariable String name){
//        return patientService.update(id, name);
//    }
}

package com.example.clinica_odonto.controller;

import com.example.clinica_odonto.model.Patient;
import com.example.clinica_odonto.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("create")
    public Patient createPatient(){
        return patientService.create();
    }

    @GetMapping("patients")
    public Map<Integer, Patient> listPatients(){
        return patientService.list();
    }

    @GetMapping("delete/{id}")
    public String deletePatient(@PathVariable Integer id){
        patientService.delete(id);
        return "Paciente deletado";
    }

    @GetMapping("search/{id}")
    public Patient searchPatient(@PathVariable Integer id){
        return patientService.search(id);
    }

    @GetMapping("update/{id}/{name}")
    public Patient updatePatient(@PathVariable Integer id, @PathVariable String name){
        return patientService.update(id, name);
    }
}

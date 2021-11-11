package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Patient;
import com.example.clinica_odonto.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {
    private static Map<Integer, Patient> patientMap = new HashMap<>();
    private static Integer idGlobal = 1;

    private static String[] names = {"Lucas", "Ana", "Pedro", "Julia", "Roberto",
            "Larissa", "Antonio", "Pietra", "Rubens", "Giovana"};

    private static String[] lastnames = {"Silva", "Santos", "Gomes", "Paglia", "Grisa",
            "Andrade", "Quinteiros", "Tempesta", "Franco", "Andrade"};

    @Override
    public Patient create() {
        Random random = new Random();
        int numRamd = 10;
        String name = names[random.nextInt(numRamd)];
        String lastname = lastnames[random.nextInt(numRamd)];
        String email = name.toLowerCase() + lastname.toLowerCase() + "@dh.com.br";
        Integer id = patientMap.size() + 1;

        patientMap.put(idGlobal++, new Patient(name, lastname, email, (random.nextInt(12, 80))));
        return patientMap.get(id);
    }

    @Override
    public Map<Integer, Patient> list() {
        return patientMap;
    }

    @Override
    public void delete(Integer id) {
        patientMap.remove(id);
    }

    @Override
    public Patient search(Integer id) {
        return patientMap.get(id);
    }

    @Override
    public Patient update(Integer id, String name) {
        Patient patient = search(id);
       patient.setName(name);
       patient.setEmail(name.toLowerCase() + patient.getLastname().toLowerCase() + "@dh.com.br");
       return patient;
    }
}

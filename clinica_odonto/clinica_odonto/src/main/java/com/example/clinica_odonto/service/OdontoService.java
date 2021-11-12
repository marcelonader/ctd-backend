package com.example.clinica_odonto.service;

import com.example.clinica_odonto.model.Patient;

import java.util.Map;

public interface OdontoService {
    Patient create();
    Map<Integer, Patient> list();
    void delete(Integer id);
    Patient search(Integer id);
    Patient update(Integer id, String name);
}

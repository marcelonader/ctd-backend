package com.example.clinica_odonto.service;

import com.example.clinica_odonto.model.Patient;

import java.util.Map;

public interface OdontoService<T> {
    T create(T t);
    Map<Integer, T> listAll();
    void delete(Integer id);
    T search(Integer id);
    T update(T t);
}

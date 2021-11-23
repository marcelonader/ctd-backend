package com.example.clinica_odontologica_16_11_2021.service;

public interface OdontoService<T>{
    T save(T t);
    T searchById(Integer id);
}

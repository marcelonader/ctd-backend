package com.example.clinica_odontologica_16_11_2021.repository;

public interface IRepository<T> {
    T save(T t);
    T searchById(Integer id);
}

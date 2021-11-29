package dev.nader.clinica_odontologica_checkpoint_2.service;

import java.util.List;

public interface IDentalService<T> {
    T save(T t);
    T getById(Integer id);
    void delete(Integer id);
    List<T> getAll();
    T update(T t);
}

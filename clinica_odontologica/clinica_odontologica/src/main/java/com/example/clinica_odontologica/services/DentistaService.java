package com.example.clinica_odontologica.services;

import com.example.clinica_odontologica.domain.Dentista;

import java.util.List;

public interface DentistaService {
    List<Dentista> listarTodos();
    Dentista buscarPorId(Integer id);
}

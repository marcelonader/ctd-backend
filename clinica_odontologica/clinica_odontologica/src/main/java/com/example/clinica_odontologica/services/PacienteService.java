package com.example.clinica_odontologica.services;

import com.example.clinica_odontologica.domain.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> listarTodos();
    Paciente buscarPorEmail(String email);
    Paciente buscarPorId(Integer id);
}
package com.example.clinica_odontologica.services.Impl;

import com.example.clinica_odontologica.domain.Endereco;
import com.example.clinica_odontologica.domain.Paciente;
import com.example.clinica_odontologica.services.PacienteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {
    private Endereco endereco = new Endereco("Rua Clovis", "14", "São Paulo", "SP");
    private Endereco endereco2 = new Endereco("Rua Mendes", "140", "Belo Horizonte", "MG");

    private Paciente paciente = new Paciente(1, "John", "Dutra", "johndutra@email.com", "12345678909", LocalDate.now(), endereco);
    private Paciente paciente2 = new Paciente(2, "Neide", "Blanco", "neideblanco@email.com", "98765432112", LocalDate.now(), endereco2);

    @Override
    public List<Paciente> listarTodos() {
        return Arrays.asList(paciente, paciente2);
    }

    @Override
    public Paciente buscarPorEmail(String email) {
        if(email.equalsIgnoreCase(paciente.getEmail()))
            return paciente;
        else if(email.equalsIgnoreCase(paciente2.getEmail()))
            return paciente2;

        return null;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return null;
    }
}

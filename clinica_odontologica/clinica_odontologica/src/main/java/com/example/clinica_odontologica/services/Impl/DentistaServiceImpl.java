package com.example.clinica_odontologica.services.Impl;

import com.example.clinica_odontologica.domain.Dentista;
import com.example.clinica_odontologica.domain.Endereco;
import com.example.clinica_odontologica.domain.Paciente;
import com.example.clinica_odontologica.services.DentistaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DentistaServiceImpl implements DentistaService {

    private Endereco endereco = new Endereco("Rua Clovis", "14", "São Paulo", "SP");
    private Endereco endereco2 = new Endereco("Rua Mendes", "140", "Belo Horizonte", "MG");

    private Paciente paciente = new Paciente(1, "John", "Dutra", "johndutra@email.com", "12345678909", LocalDate.now(), endereco);
    private Paciente paciente2 = new Paciente(2, "Neide", "Blanco", "neideblanco@email.com", "98765432112", LocalDate.now(), endereco2);

    private Dentista dentista = new Dentista(1, "Raquel", "Dantas", "2136541");
    private Dentista dentista2 = new Dentista(2, "Ruth", "Carvalhosa", "2548652");

    @Override
    public List<Dentista> listarTodos() {
        dentista.adicionarPaciente(paciente);
        dentista.adicionarPaciente(paciente2);
        return Arrays.asList(dentista, dentista2);
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        if(id == dentista.getId())
            return dentista;
        else if(id == dentista2.getId())
            return dentista2;
        return null;
    }
}

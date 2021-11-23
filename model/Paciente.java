package com.example.aula25integradora.model;

import com.example.aula25integradora.dto.PacienteDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paciente {
    private Integer id;
    private String nome;
    private String sobrenome;
    private Endereco endereco;

    public Paciente(){}

    public Paciente(PacienteDTO pacienteDTO, Endereco endereco) {
        this.id = pacienteDTO.getId();
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.endereco = endereco;
    }

}

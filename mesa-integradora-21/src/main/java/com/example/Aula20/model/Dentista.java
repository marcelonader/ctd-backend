package com.example.Aula20.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dentista {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String matricula;
    private Paciente paciente;
    private Integer idPaciente;
}

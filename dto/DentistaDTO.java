package com.example.aula25integradora.dto;

import com.example.aula25integradora.model.Dentista;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistaDTO {
    private Integer id;
    private Integer numMatricula;
    private String nome;
    private String sobrenome;

    public DentistaDTO(){}

    public DentistaDTO(Dentista dentista) {
        this.id = dentista.getId();
        this.numMatricula = dentista.getNumMatricula();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
    }
}

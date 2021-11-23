package com.example.aula25integradora.model;

import com.example.aula25integradora.dto.EnderecoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private Integer id;
    private String rua;
    private String numero;

    public Endereco(){}

    public Endereco(EnderecoDTO enderecoDTO){
        this.id = enderecoDTO.getId();
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
    }
}

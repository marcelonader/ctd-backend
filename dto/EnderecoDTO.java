package com.example.aula25integradora.dto;

import com.example.aula25integradora.model.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
    private Integer id;
    private String rua;
    private String numero;

    public EnderecoDTO(){}

    public EnderecoDTO(Endereco endereco){
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
    }
}

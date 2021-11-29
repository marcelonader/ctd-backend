package dev.nader.mesaintegradora1911.model;

import dev.nader.mesaintegradora1911.dto.EnderecoDTO;
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

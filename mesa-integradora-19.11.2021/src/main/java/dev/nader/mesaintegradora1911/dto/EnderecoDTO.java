package dev.nader.mesaintegradora1911.dto;


import dev.nader.mesaintegradora1911.model.Endereco;
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

package dev.nader.mesaintegradora.dto;

import dev.nader.mesaintegradora.model.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer idEndereco;

    public PacienteDTO(){}

    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.idEndereco = paciente.getEndereco().getId();
    }
}

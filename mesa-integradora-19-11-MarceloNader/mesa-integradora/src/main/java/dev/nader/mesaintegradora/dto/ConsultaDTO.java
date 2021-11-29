package dev.nader.mesaintegradora.dto;

import dev.nader.mesaintegradora.model.Consulta;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ConsultaDTO {
    private Integer id;
    private Integer idPaciente;
    private Integer idDentista;
    private Date dataHoraConsulta;

    public ConsultaDTO(){}

    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.idPaciente = consulta.getPaciente().getId();
        this.idDentista = consulta.getDentista().getId();
        this.dataHoraConsulta = consulta.getDataHoraConsulta();
    }
}

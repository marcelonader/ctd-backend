package dev.nader.mesaintegradora1911.model;

import dev.nader.mesaintegradora1911.dto.ConsultaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Consulta {
    private Integer id;
    private Paciente paciente;
    private Dentista dentista;
    private Date dataHoraConsulta;

    public Consulta(){}

    public Consulta(ConsultaDTO consultaDTO, Paciente paciente, Dentista dentista) {
        this.id = consultaDTO.getId();
        this.paciente = paciente;
        this.dentista = dentista;
        this.dataHoraConsulta = consultaDTO.getDataHoraConsulta();
    }
}

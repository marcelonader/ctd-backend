package dev.nader.clinica_odontologica_checkpoint_2.dto;

import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.DentistEntity;
import lombok.Data;

@Data
public class DentistDTO {
    private Integer id;
    private String fullname;
    private Integer registerNumber;

    public DentistDTO (DentistEntity dentistEntity){
        this.id = dentistEntity.getId();
        this.fullname = dentistEntity.getName() + " " + dentistEntity.getLastname();
        this.registerNumber = dentistEntity.getRegisterNumber();
    }
}

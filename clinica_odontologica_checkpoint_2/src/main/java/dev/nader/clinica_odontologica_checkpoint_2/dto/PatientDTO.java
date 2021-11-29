package dev.nader.clinica_odontologica_checkpoint_2.dto;

import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.PatientEntity;
import lombok.Data;

@Data
public class PatientDTO {
    private Integer id;
    private String fullname;
    private String streetAddress;
    private String numberAddress;

    public PatientDTO (PatientEntity patientEntity){
        this.id = patientEntity.getId();
        this.fullname = patientEntity.getName() + " " + patientEntity.getLastname();
        this.streetAddress = patientEntity.getAddress().getStreet();
        this.numberAddress = patientEntity.getAddress().getNumber();
    }
}

package dev.nader.clinica_odontologica_checkpoint_2.dto;

import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.AddressEntity;
import lombok.Data;

@Data
public class AddressDTO {

    private Integer id;
    private String street;
    private String number;

    public AddressDTO (AddressEntity addressEntity){
        this.id = addressEntity.getId();
        this.street = addressEntity.getStreet();
        this.number = addressEntity.getNumber();
    }
}

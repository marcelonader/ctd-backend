package dev.nader.clinica_odontologica_checkpoint_2.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="DENTISTS")
public class DentistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="register_number")
    private Integer registerNumber;
    private String name;
    private String lastname;
}

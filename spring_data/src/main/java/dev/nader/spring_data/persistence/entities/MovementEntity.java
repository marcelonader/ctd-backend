package dev.nader.spring_data.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="TABLE_MOVEMENTS")   // -> TABLA_MOVIMENTOS
@Getter
@Setter
public class MovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID")
    private Integer id;

    @Column(name="DESCRIPTION")  // -> DESC
    private String description;  // -> descricao

    @Column(name="QUANTITY")     // -> QUANTIA
    private Double quantity;     // -> quantidade


}

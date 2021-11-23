package dev.nader.aula_23_11_2021.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="TEACHERS")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String course;
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private Set<StudentEntity> students = new HashSet<>();



}

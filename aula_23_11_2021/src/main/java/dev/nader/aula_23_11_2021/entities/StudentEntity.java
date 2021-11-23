package dev.nader.aula_23_11_2021.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="STUDENTS")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private Integer age;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

}
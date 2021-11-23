package com.example.clinica_odontologica.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dentista {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String matricula;
    private List<Paciente> listaPacientes = new ArrayList<>();

    public Dentista(Integer id, String nome, String sobrenome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
    }
    public void adicionarPaciente(Paciente paciente){
        listaPacientes.add(paciente);
    }
    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public List<Paciente> getListaPacientes(){
        return listaPacientes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

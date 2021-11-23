package com.example.clinica_odontologica.controller;

import com.example.clinica_odontologica.domain.Paciente;
import com.example.clinica_odontologica.services.Impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PacienteController {

    @Autowired
   PacienteServiceImpl pacienteService;


    @GetMapping("{tipo}/buscaPorEmail")
    public String buscarPorEmail(Model model, @PathVariable String tipo, @RequestParam("email") String email) {
        Paciente paciente = pacienteService.buscarPorEmail(email);
        model.addAttribute("tipo", tipo);
        model.addAttribute("nome", paciente.getNome());
        model.addAttribute("sobrenome", paciente.getSobrenome());
        return "index";
    }

    @GetMapping("{tipo}/listarPacientes")
    public String getPacientes(Model model, @PathVariable String tipo) {
        model.addAttribute("tipo", tipo);
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "index";
    }
}
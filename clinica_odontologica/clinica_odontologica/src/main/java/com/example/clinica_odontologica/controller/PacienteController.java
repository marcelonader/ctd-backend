package com.example.clinica_odontologica.controller;

import com.example.clinica_odontologica.domain.Paciente;
import com.example.clinica_odontologica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PacienteController {
    private final PacienteService pacienteService;
    public static final String VIEW_PACIENTE = "paciente";

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/buscaPorEmail")
    public String buscarPorEmail(Model model, @RequestParam("email") String email) {
        Paciente paciente = pacienteService.buscarPorEmail(email);
        model.addAttribute("nome", paciente.getNome());
        model.addAttribute("sobrenome", paciente.getSobrenome());
        return VIEW_PACIENTE;
    }

    @GetMapping("/pacientes")
    public String getPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return VIEW_PACIENTE;
    }
}
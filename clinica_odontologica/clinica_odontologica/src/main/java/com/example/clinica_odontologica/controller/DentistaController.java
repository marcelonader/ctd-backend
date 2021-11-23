package com.example.clinica_odontologica.controller;

import com.example.clinica_odontologica.domain.Dentista;
import com.example.clinica_odontologica.services.Impl.DentistaServiceImpl;
import com.example.clinica_odontologica.services.Impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DentistaController {

    @Autowired
    DentistaServiceImpl dentistaService;

    @GetMapping("{tipo}/buscaPorId")
    public String buscarPorId(Model model, @PathVariable String tipo, @RequestParam("id") Integer id) {
        Dentista dentista = dentistaService.buscarPorId(id);
        model.addAttribute("tipo", tipo);
        model.addAttribute("nome", dentista.getNome());
        model.addAttribute("sobrenome", dentista.getSobrenome());
        return "index";
    }

    @GetMapping("{tipo}/listarDentistas")
    public String getDentistas(Model model, @PathVariable String tipo) {
        model.addAttribute("tipo", tipo);
        model.addAttribute("dentistas", dentistaService.listarTodos());
        return "index";
    }
}
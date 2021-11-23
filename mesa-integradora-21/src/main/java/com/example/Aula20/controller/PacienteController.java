package com.example.Aula20.controller;

import com.example.Aula20.model.Paciente;
import com.example.Aula20.service.impl.PacienteServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }


    @GetMapping("listar")
    public Map<Integer, Paciente> buscarTodos(){
        return pacienteService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        ResponseEntity<String> response = null;

        if(pacienteService.buscarPorId(id) != null){
            pacienteService.deletar(id);
           return response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente removido com sucesso");
        }
         response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não localizado");
         return  response;
    }

    @PutMapping
    public ResponseEntity<Paciente> atualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;

        if(paciente.getId() != null && paciente.getEndereco().getId() != null)
            response = ResponseEntity.ok(pacienteService.atualizar(paciente));

        response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }
}

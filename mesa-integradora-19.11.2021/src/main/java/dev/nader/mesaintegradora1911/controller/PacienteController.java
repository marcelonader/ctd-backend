package dev.nader.mesaintegradora1911.controller;

import dev.nader.mesaintegradora1911.model.Paciente;
import dev.nader.mesaintegradora1911.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente (@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPaciente(@PathVariable Integer id){
        Paciente paciente = pacienteService.buscarPorId(id);

        if(paciente == null){
            return ResponseEntity.badRequest().body("Paciente não encontrado");
        }
        return ResponseEntity.ok(paciente);
    }
    @GetMapping
    public ResponseEntity<Map<Integer, Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPaciente(@PathVariable Integer id){
        if(pacienteService.buscarPorId(id) == null){
            return ResponseEntity.badRequest().body("Paciente não encontrado");
        }
        pacienteService.deletar(id);
        return ResponseEntity.ok("Paciente deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarPaciente(@PathVariable Integer id, @RequestBody Paciente paciente){
        if(pacienteService.buscarPorId(id) == null){
            return ResponseEntity.badRequest().body("Paciente não encontrado");
        }
        return ResponseEntity.ok(pacienteService.atualizar(id, paciente));
    }

}

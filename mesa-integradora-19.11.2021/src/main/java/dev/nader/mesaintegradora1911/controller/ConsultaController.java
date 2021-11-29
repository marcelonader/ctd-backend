package dev.nader.mesaintegradora1911.controller;

import dev.nader.mesaintegradora1911.model.Consulta;
import dev.nader.mesaintegradora1911.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping
    public ResponseEntity salvarConsulta(@RequestBody Consulta consulta){
        Consulta consultaSalvar = consultaService.salvar(consulta);
        if(consultaSalvar != null){
            return ResponseEntity.ok(consultaSalvar);
        }
        return ResponseEntity.badRequest().body("Erro ao salvar consulta");

    }

    @GetMapping("/{id}")
    public ResponseEntity buscarConsultaPorId(@PathVariable Integer id){
        Consulta consulta = consultaService.buscarPorId(id);
        if(consulta != null){
            return ResponseEntity.ok(consulta);
        }
        return ResponseEntity.badRequest().body("Erro ao buscar consulta");
    }
    @GetMapping
    public ResponseEntity<Map<Integer, Consulta>> buscarTodasConsultas(){
        return ResponseEntity.ok(consultaService.buscarTodos());
    }
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        consultaService.deletar(id);
        return "Consulta deletada com sucesso";
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Integer id, @RequestBody Consulta consulta){
        Consulta consultaAtualizar = consultaService.atualizar(id, consulta);
        if(consultaAtualizar != null){
            return ResponseEntity.ok(consultaAtualizar);
        }
        return ResponseEntity.badRequest().body("Erro ao atualizar consulta");
    }
}

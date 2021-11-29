package dev.nader.mesaintegradora1911.controller;

import dev.nader.mesaintegradora1911.model.Dentista;
import dev.nader.mesaintegradora1911.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {
    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping
    public ResponseEntity<Dentista> salvarDentista(@RequestBody Dentista dentista){
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }
    @GetMapping("/{id}")
    public ResponseEntity buscarDenstistaPorId(@PathVariable Integer id){
        Dentista dentista = dentistaService.buscarPorId(id);
        if(dentista == null){
            return ResponseEntity.badRequest().body("Dentista não encontrado");
        }
        return ResponseEntity.ok(dentista);
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Dentista>> buscarTodos(){
        return ResponseEntity.ok(dentistaService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarDentista(@PathVariable Integer id){
        dentistaService.deletar(id);
        return ResponseEntity.ok("Dentista deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dentista> atualizarDentista(@PathVariable Integer id, @RequestBody Dentista dentista){
        return ResponseEntity.ok(dentistaService.atualizar(id, dentista));
    }
}


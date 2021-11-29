package dev.nader.mesaintegradora1911.controller;

import dev.nader.mesaintegradora1911.model.Endereco;
import dev.nader.mesaintegradora1911.repository.impl.EnderecoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoRepositoryImpl enderecoRepository;

    @PostMapping
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco){
        return ResponseEntity.ok(enderecoRepository.salvar(endereco));
    }

    @GetMapping
    public ResponseEntity<Map<Integer,Endereco>> buscarTodos(){
        return ResponseEntity.ok(enderecoRepository.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Integer id){
        Endereco endereco = enderecoRepository.buscarPorId(id);
        if(endereco == null){
            return ResponseEntity.badRequest().body("Endereço não encontrado");
        }
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        Endereco endereco = enderecoRepository.buscarPorId(id);
        if(endereco == null){
            return ResponseEntity.badRequest().body("Endereço não encontrado");
        }
        enderecoRepository.deletar(id);
        return ResponseEntity.ok("Endereço deletado com sucesso");
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Integer id, @RequestBody Endereco endereco){
        Endereco enderecoAtual = enderecoRepository.buscarPorId(id);
        if(enderecoAtual == null){
            return ResponseEntity.badRequest().body("Endereço não encontrado");
        }
        return ResponseEntity.ok(enderecoRepository.atualizar(id, endereco));
    }



}

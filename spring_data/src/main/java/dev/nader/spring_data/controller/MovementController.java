package dev.nader.spring_data.controller;


import dev.nader.spring_data.persistence.entities.MovementEntity;
import dev.nader.spring_data.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
public class MovementController {

    @Autowired
    MovementService movementService;

    @PostMapping("/post")
    public ResponseEntity<String> save(@RequestBody MovementEntity movement){
        ResponseEntity<String> response = null;
        if(movementService.save(movement) != null)
            response = ResponseEntity.ok("Movimento salvo com sucesso");
        else
            response = ResponseEntity.internalServerError().body("Deu ruim");
        return response;
    }

    @GetMapping("get")
    public ResponseEntity<List<MovementEntity>> getAll(){
        return ResponseEntity.ok(movementService.getAll());
    }
}

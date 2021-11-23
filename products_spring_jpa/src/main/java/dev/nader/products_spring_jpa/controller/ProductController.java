package dev.nader.products_spring_jpa.controller;

import dev.nader.products_spring_jpa.persistences.entities.ProductEntity;
import dev.nader.products_spring_jpa.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;


    @PostMapping("/")
    public ResponseEntity save(@RequestBody ProductEntity product){
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody ProductEntity productChange){
        return ResponseEntity.ok(productService.update(productChange));
    }

    @GetMapping("/")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(productService.searchAll());
    }

    @GetMapping("/{productId}/reduceQuantity/{quantity}")
    public ResponseEntity reduceQuantity(@PathVariable Integer productId, @PathVariable Integer quantity){
        return ResponseEntity.ok(productService.reduceQuantity(productId, quantity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        productService.deleteById(id);
        return ResponseEntity.ok("usuário deletado com sucesso!");
    }

}

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


    /**
     * Cadastra um novo produto no banco de dados.
     * @param product
     * @return
     */
    @PostMapping("/")
    public ResponseEntity save(@RequestBody ProductEntity product){
        return ResponseEntity.ok(productService.save(product));
    }

    /**
     * Atualiza os dados de um produto, passando os novos dados no corpo da requisição.
     * @param productChange
     * @return
     */
    @PutMapping("/")
    public ResponseEntity update(@RequestBody ProductEntity productChange){
        return ResponseEntity.ok(productService.update(productChange));
    }

    /**
     * retorna a lista completa com todos os produtos.
     * @return
     */
    @GetMapping("/listAll")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(productService.searchAll());
    }

    /**
     * Reduz a quantidade de um produto, passando como parâmetros na URL o ID do produto e a quantidade a ser reduzida.
     * @param productId
     * @param quantity
     * @return
     */
    @GetMapping("/{productId}/reduceQuantity/{quantity}")
    public ResponseEntity reduceQuantity(@PathVariable Integer productId, @PathVariable Integer quantity){
        return ResponseEntity.ok(productService.reduceQuantity(productId, quantity));
    }

    /**
     * Deleta um produto, passando o ID dele como parâmetro na URL.
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        productService.deleteById(id);
        return ResponseEntity.ok("usuário deletado com sucesso!");
    }

}

package dev.nader.products_spring_jpa.services;

import dev.nader.products_spring_jpa.persistences.entities.ProductEntity;
import dev.nader.products_spring_jpa.persistences.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {

    ProductEntity save(ProductEntity product);
    void deleteById(Integer id);
    List<ProductEntity> searchAll();
    ProductEntity update(ProductEntity product);
    ProductEntity reduceQuantity(Integer productId, Integer quantity);
}

package dev.nader.products_spring_jpa.persistences.repository;

import dev.nader.products_spring_jpa.persistences.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}

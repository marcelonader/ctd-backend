package dev.nader.products_spring_jpa.services.impl;

import dev.nader.products_spring_jpa.persistences.entities.ProductEntity;
import dev.nader.products_spring_jpa.persistences.repository.ProductRepository;
import dev.nader.products_spring_jpa.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {


    private ProductRepository productRepository;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductEntity> searchAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity update(ProductEntity product) {

       ProductEntity productBase = productRepository.getById(product.getId());
       if(product.getName() != null)
           productBase.setName(product.getName());
       if(product.getDescription() != null)
            productBase.setDescription(product.getDescription());
       if(product.getQuantity() != null)
            productBase.setQuantity(product.getQuantity());

       return productRepository.saveAndFlush(productBase);
    }

    @Override
    public ProductEntity reduceQuantity(Integer productId, Integer quantity) {
        ProductEntity productBase = productRepository.getById(productId);
        if(productBase.getQuantity() >= quantity)
            productBase.setQuantity(productBase.getQuantity() - quantity);
        return productRepository.saveAndFlush(productBase);
    }

}

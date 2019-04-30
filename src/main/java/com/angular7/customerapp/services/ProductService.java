package com.angular7.customerapp.services;

import com.angular7.customerapp.generics.Generic;
import com.angular7.customerapp.models.Product;
import com.angular7.customerapp.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements Generic<Product> {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAllByIsActive();
    }

    @Override
    public Product saveOrUpdate(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }
}

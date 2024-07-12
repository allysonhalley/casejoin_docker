package com.hemti.casejoin.service;

import com.hemti.casejoin.model.product.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(String id);
    Product save(Product product);
    Product update(Product product);
    void deleteById(String id);
    boolean existsById(String id);
}

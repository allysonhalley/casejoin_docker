package com.hemti.casejoin.service.implement;

import com.hemti.casejoin.model.category.Category;
import com.hemti.casejoin.model.product.Product;
import com.hemti.casejoin.repository.ProductRepository;
import com.hemti.casejoin.service.ProductService;
import org.hibernate.annotations.NotFound;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) throws ServiceException {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        Product updatedProduct = productOptional.orElse(null);
        if (productOptional.isPresent()) {
            updatedProduct.setId(product.getId());
            updatedProduct.setName(product.getName());
            updatedProduct.setCategory(product.getCategory());
        }
        return productRepository.save(updatedProduct);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return productRepository.existsById(id);
    }
}

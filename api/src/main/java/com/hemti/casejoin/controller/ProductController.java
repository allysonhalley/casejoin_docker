package com.hemti.casejoin.controller;

import com.hemti.casejoin.model.category.Category;
import com.hemti.casejoin.model.product.Product;
import com.hemti.casejoin.model.product.ProductResponseDTO;
import com.hemti.casejoin.service.CategoryService;
import com.hemti.casejoin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4242")@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        try {
            return ResponseEntity.ok(productService.findAll());
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody ProductResponseDTO productResponseDto) {
        try {
            Category category = categoryService.findById(productResponseDto.category_id());
            Product product = new Product(productResponseDto.name(), category);
            return ResponseEntity.ok(productService.save(product));
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        try {
            return ResponseEntity.ok(productService.findById(id));
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.update(product));
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id) {
        try {
            productService.deleteById(id);
            return ResponseEntity.ok("Product deleted successfully");
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

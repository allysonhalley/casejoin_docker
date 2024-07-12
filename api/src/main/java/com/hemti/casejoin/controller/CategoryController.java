package com.hemti.casejoin.controller;

import com.hemti.casejoin.model.category.Category;
import com.hemti.casejoin.model.category.CategoryDTO;
import com.hemti.casejoin.service.CategoryService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4242")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> getCategories() throws Exception {
        try {
            List<Category> categories = new ArrayList<>(categoryService.findAll());
            return ResponseEntity.ok().body(categories);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDto) throws Exception {
        try {
            Category category = categoryService.save(new Category(categoryDto));
            return ResponseEntity.ok(category);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") String id) throws Exception {
        try {
            return ResponseEntity.ok(categoryService.findById(id));
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        try {
            return ResponseEntity.ok(categoryService.update(category));
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/category-by-name/{name}")
    public ResponseEntity<List<Category>> getCategoryByName(@PathVariable("name") String name) throws Exception {
        try {
            return ResponseEntity.ok(categoryService.findByName(name));
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id) throws Exception {
        try {
            categoryService.delete(id);
            return ResponseEntity.ok("Category deleted successfully");
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}

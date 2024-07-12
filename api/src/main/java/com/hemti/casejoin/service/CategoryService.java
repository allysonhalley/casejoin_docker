package com.hemti.casejoin.service;

import com.hemti.casejoin.model.category.Category;

import java.util.List;

public interface CategoryService{

    List<Category> findAll();
    Category findById(String id);
    List<Category> findByName(String name);
    Category save(Category category);
    void delete(String id);
    Category update(Category category);
    boolean exists(String id);

}

package com.hemti.casejoin.repository;

import com.hemti.casejoin.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
        List<Category> findCategoryByNameContainsIgnoreCase(String name);
}

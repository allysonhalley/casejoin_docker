package com.hemti.casejoin.service.implement;

import com.hemti.casejoin.model.category.Category;
import com.hemti.casejoin.model.product.Product;
import com.hemti.casejoin.repository.CategoryRepository;
import com.hemti.casejoin.service.CategoryService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.findCategoryByNameContainsIgnoreCase(name);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category update(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(category.getId());
        Category updatedCategory = new Category();
        if (categoryOptional.isPresent()) {
            updatedCategory.setId(category.getId());
            updatedCategory.setName(category.getName());
            updatedCategory.setDescription(category.getDescription());
        }
        return categoryRepository.save(updatedCategory);
    }

    @Override
    public boolean exists(String id) {
        return categoryRepository.existsById(id);
    }
}

package com.greg.spring_boot_learning.api_products.service;

import com.greg.spring_boot_learning.api_products.domains.Category;
import com.greg.spring_boot_learning.api_products.exception.CategoryNotFoundException;
import com.greg.spring_boot_learning.api_products.infra.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public void createCategory(Category category) {
        repository.save(category);
    }

    public List<Category> findAllCategory() {
        return repository.findAll();
    }

    public Category findCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }
}

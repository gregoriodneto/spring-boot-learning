package com.greg.spring_boot_learning.api_products.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("Categoria com ID " + id + " não encontrado.");
    }
}

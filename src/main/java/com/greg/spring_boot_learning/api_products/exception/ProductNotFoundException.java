package com.greg.spring_boot_learning.api_products.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Produto com ID " + id + " não encontrado.");
    }
}

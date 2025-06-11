package com.greg.spring_boot_learning.api_products;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/*
* Especialização de @Component, usada para classes de lógica de negócio.
*
* O @RequiredArgsConstructor cria um construtor com todos os campos final, e o Spring vai usar ele automaticamente para fazer a injeção.
* */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public void createProduct(String nome, double preco) {
        Product product = new Product(nome, Math.max(preco, 0.01));
        repository.create(product);
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public Product findProductById(int id) {
        return repository.findById(id);
    }

    public boolean deleteProductById(int id) {
        return repository.delete(id);
    }

    public Product updateProduct(int id, Product product) {
        Product existingProduct = repository.findById(id);
        if (existingProduct == null) {
            return null;
        }
        existingProduct.setNome(product.getNome());
        existingProduct.setPreco(product.getPreco());
        return existingProduct;
    }
}

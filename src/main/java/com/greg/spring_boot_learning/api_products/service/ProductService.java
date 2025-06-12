package com.greg.spring_boot_learning.api_products.service;

import com.greg.spring_boot_learning.api_products.domains.Product;
import com.greg.spring_boot_learning.api_products.infra.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void createProduct(Product product) {
        repository.save(product);
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public Product findProductById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }

    public Product updateProduct(Long id, Product newData) {
        Product existingProduct = repository.findById(id).orElseThrow();
        existingProduct.setNome(newData.getNome());
        existingProduct.setPreco(newData.getPreco());
        return repository.save(existingProduct);
    }
}

package com.greg.spring_boot_learning.api_products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
*	Especialização de @Component, usada para classes que acessam o banco de dados. Pode tratar exceções de banco.
* */
@Repository
public class ProductRepository {
    private List<Product> products;

    @Autowired
    public ProductRepository() {
        products = new ArrayList<>();
    }

    public void create(Product product) {
        if (products.isEmpty()) {
            product.setId(1);
        } else {
            product.setId(products.getLast().getId() + 1);
        }
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }
}

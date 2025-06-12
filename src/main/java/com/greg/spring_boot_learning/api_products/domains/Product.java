package com.greg.spring_boot_learning.api_products.domains;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {}

    public Product(String nome, Double preco, Category category) {
        this.nome = nome;
        this.preco = preco;
        this.category = category;
    }
}

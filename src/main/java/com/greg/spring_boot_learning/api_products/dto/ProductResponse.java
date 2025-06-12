package com.greg.spring_boot_learning.api_products.dto;

public record ProductResponse(
        Long id,
        String nome,
        Double preco,
        String nomeCategoria
) { }

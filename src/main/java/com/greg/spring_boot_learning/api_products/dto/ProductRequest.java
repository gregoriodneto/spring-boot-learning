package com.greg.spring_boot_learning.api_products.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        @NotBlank(message = "Nome do Produto não pode ser vazio")
        String nome,
        @DecimalMin(value = "0.01", inclusive = true, message = "Preço deve ser maior que zero.")
        double preco,
        @NotNull
        Long categoryId
) {}

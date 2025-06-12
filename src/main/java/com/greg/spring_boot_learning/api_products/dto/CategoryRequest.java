package com.greg.spring_boot_learning.api_products.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @NotBlank(message = "Nome da Categoria não pode ser vazio.")
        String nome
) {
}

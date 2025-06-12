package com.greg.spring_boot_learning.api_products.app;

import com.greg.spring_boot_learning.api_products.domains.Category;
import com.greg.spring_boot_learning.api_products.dto.CategoryRequest;
import com.greg.spring_boot_learning.api_products.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CategoryRequest request) {
        Category category = new Category(request.nome());
        service.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria " + request.nome() + " criada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Category> categories = service.findAllCategory();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> findById(@PathVariable Long categoryId) {
        if (categoryId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID da Categoria inválida.");
        }
        Category category = service.findCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }
}

package com.greg.spring_boot_learning.api_products.app;

import com.greg.spring_boot_learning.api_products.domains.Category;
import com.greg.spring_boot_learning.api_products.dto.ProductRequest;
import com.greg.spring_boot_learning.api_products.dto.ProductResponse;
import com.greg.spring_boot_learning.api_products.service.CategoryService;
import com.greg.spring_boot_learning.api_products.service.ProductService;
import com.greg.spring_boot_learning.api_products.domains.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Combina @Controller + @ResponseBody, usada para APIs REST que retornam JSON.
*
* O @Controller é usada para criar controllers MVC que retornam views (HTML, JSP, etc.).
* */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;
    private final CategoryService categoryService;

    /*
    * O Spring recomenda injeção via construtor (ao invés de @Autowired direto no campo), pois:
        facilita testes unitários,
        melhora a imutabilidade,
        favorece boas práticas do SOLID (princípio de inversão de dependência).
    * */
    @Autowired
    public ProductController(
            ProductService service,
            CategoryService categoryService
    ) {
        this.service = service;
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductRequest request) {
        Category category = categoryService.findCategoryById(request.categoryId());
        Product product = new Product(request.nome(), request.preco(), category);
        service.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto " + request.nome() + " criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<?> findAllProducts() {
        List<Product> products = service.findAllProducts();
        List<ProductResponse> response = products.stream()
                .map(p -> new ProductResponse(
                        p.getId(),
                        p.getNome(),
                        p.getPreco(),
                        p.getCategory().getNome()
                ))
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> findProductById(@PathVariable Long productId) {
        Product product = service.findProductById(productId);
        ProductResponse response = new ProductResponse(
                product.getId(),
                product.getNome(),
                product.getPreco(),
                product.getCategory().getNome()
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long productId) {
        service.findProductById(productId);
        service.deleteProductById(productId);
        return ResponseEntity.ok("Produto deletado com sucesso!");
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody @Valid ProductRequest request) {
        Category category = categoryService.findCategoryById(request.categoryId());
        Product product = new Product(request.nome(), request.preco(), category);
        Product response = service.updateProduct(productId, product);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não existe na base de dados.");
        }
        return ResponseEntity.ok("Atualização do Produto="+ request.nome() + " realizada com sucesso!");
    }
}

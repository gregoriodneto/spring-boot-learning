package com.greg.spring_boot_learning.api_products;

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

    /*
    * O Spring recomenda injeção via construtor (ao invés de @Autowired direto no campo), pois:
        facilita testes unitários,
        melhora a imutabilidade,
        favorece boas práticas do SOLID (princípio de inversão de dependência).
    * */
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductRequest request) {
        service.createProduct(request.nome(), request.preco());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto " + request.nome() + " criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<?> findAllProducts() {
        List<Product> products = service.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> findProductById(@PathVariable int productId) {
        Product product = service.findProductById(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto com ID="+ productId + " Não encontrado");
        }
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable int productId) {
        boolean deleted = service.deleteProductById(productId);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não existe na base de dados.");
        }
        return ResponseEntity.ok("Produto deletado com sucesso!");
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable int productId, @RequestBody @Valid ProductRequest request) {
        Product product = new Product(request.nome(), request.preco());
        Product response = service.updateProduct(productId, product);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não existe na base de dados.");
        }
        return ResponseEntity.ok("Atualização do Produto="+ request.nome() + " realizada com sucesso!");
    }
}

package com.greg.spring_boot_learning.api_products.infra;

import com.greg.spring_boot_learning.api_products.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
*	Especialização de @Component, usada para classes que acessam o banco de dados. Pode tratar exceções de banco.
* */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

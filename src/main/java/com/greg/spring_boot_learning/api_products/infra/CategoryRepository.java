package com.greg.spring_boot_learning.api_products.infra;

import com.greg.spring_boot_learning.api_products.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

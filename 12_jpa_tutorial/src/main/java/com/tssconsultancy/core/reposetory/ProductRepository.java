package com.tssconsultancy.core.reposetory;

import com.tssconsultancy.core.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

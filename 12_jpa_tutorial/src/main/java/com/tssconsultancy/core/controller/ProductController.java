package com.tssconsultancy.core.controller;

import com.tssconsultancy.core.models.Product;
import com.tssconsultancy.core.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/app/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product createProduct(
            @RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {

        return productService.createProduct(name, file);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}

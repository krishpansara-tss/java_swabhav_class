package com.tssconsultancy.core.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tssconsultancy.core.models.Product;
import com.tssconsultancy.core.reposetory.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ImageService imageService;

    public Product createProduct(String name, MultipartFile file) {
        String imageUrl = imageService.uploadImage(file);

        Product product = new Product();
        product.setName(name);
        product.setImageUrl(imageUrl);

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

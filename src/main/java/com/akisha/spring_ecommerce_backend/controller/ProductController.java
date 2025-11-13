package com.akisha.spring_ecommerce_backend.controller;

import com.akisha.spring_ecommerce_backend.dto.Product;
import com.akisha.spring_ecommerce_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<Product> createProduct(Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.create(product));
    }
}

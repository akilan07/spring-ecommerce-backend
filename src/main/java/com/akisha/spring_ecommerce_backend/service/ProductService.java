package com.akisha.spring_ecommerce_backend.service;

import com.akisha.spring_ecommerce_backend.dto.Product;
import com.akisha.spring_ecommerce_backend.mapper.ProductMapper;
import com.akisha.spring_ecommerce_backend.repository.ProductRepository;
import com.akisha.spring_ecommerce_backend.repository.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Product create(Product product) {

        ProductEntity savedProduct = productRepository.save(ProductEntity.of(product.getName(), product.getPrice()));
        return productMapper.toDto(savedProduct);
    }
}

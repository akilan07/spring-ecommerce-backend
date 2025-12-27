package com.akisha.spring_ecommerce_backend;

import com.akisha.spring_ecommerce_backend.dto.Product;

public class ProductFactory {

    public static Product getProduct() {
        return Product.builder()
                .name("Sample Product")
                .price(19.99)
                .build();
    }

}

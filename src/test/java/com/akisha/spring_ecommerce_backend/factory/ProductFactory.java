package com.akisha.spring_ecommerce_backend.factory;

import com.akisha.spring_ecommerce_backend.dto.Product;

public class ProductFactory {
    public static Product getBasicProduct() {
        return Product.builder()
                .name("Iphone 17 pro")
                .price(1700000.00)
                .build();
    }
}

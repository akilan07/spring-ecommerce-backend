package com.akisha.spring_ecommerce_backend.repository.entity;

import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private Double price;

    public static ProductEntity of(String name, double price) {
        return ProductEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .price(price).build();
    }
}

package com.akisha.spring_ecommerce_backend.mapper;

import com.akisha.spring_ecommerce_backend.dto.Product;
import com.akisha.spring_ecommerce_backend.repository.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toDto(ProductEntity entity);
    ProductEntity toEntity(Product dto);
}

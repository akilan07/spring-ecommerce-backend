package com.akisha.spring_ecommerce_backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.akisha.spring_ecommerce_backend.dto.Product;
import com.akisha.spring_ecommerce_backend.factory.ProductFactory;
import com.akisha.spring_ecommerce_backend.mapper.ProductMapper;
import com.akisha.spring_ecommerce_backend.repository.ProductRepository;
import com.akisha.spring_ecommerce_backend.repository.entity.ProductEntity;
import com.mongodb.MongoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldSaveProduct() {
        Product basicProduct = ProductFactory.getBasicProduct();
        ProductEntity productEntity = ProductEntity.builder()
                .name(basicProduct.getName())
                .price(basicProduct.getPrice())
                .build();

        when(productRepository.save(any())).thenReturn(productEntity);
        when(productMapper.toDto(any())).thenReturn(basicProduct);

        Product product = productService.create(basicProduct);

        ArgumentCaptor<ProductEntity> captor = ArgumentCaptor.forClass(ProductEntity.class);
        verify(productRepository).save(captor.capture());
        assertEquals(productEntity.getName(), captor.getValue().getName());
        assertEquals(productEntity.getPrice(), captor.getValue().getPrice());
        assertNotNull(captor.getValue().getId());
        assertEquals(basicProduct, product);

    }

    @Test
    void shouldThrowExceptionWhenProductIsFailedToSave() {
        Product basicProduct = ProductFactory.getBasicProduct();
        when(productRepository.save(any(ProductEntity.class))).thenThrow(MongoException.class);

        assertThrows(MongoException.class, () -> productService.create(basicProduct));
    }

}
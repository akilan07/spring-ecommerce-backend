package com.akisha.spring_ecommerce_backend.repository;

import com.akisha.spring_ecommerce_backend.repository.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {}

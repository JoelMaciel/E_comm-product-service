package com.joel.products.infrastructure.adapters.persistence.mongo.repository;

import com.joel.products.infrastructure.adapters.persistence.mongo.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<ProductEntity, String> {

    boolean existsByName(String name);
}

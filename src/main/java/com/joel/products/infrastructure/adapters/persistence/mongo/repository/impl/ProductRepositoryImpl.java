package com.joel.products.infrastructure.adapters.persistence.mongo.repository.impl;

import com.joel.products.application.mapper.ProductMapper;
import com.joel.products.domain.entities.Product;
import com.joel.products.domain.pagination.Pagination;
import com.joel.products.domain.repositories.ProductRepository;
import com.joel.products.infrastructure.adapters.persistence.mongo.entity.ProductEntity;
import com.joel.products.infrastructure.adapters.persistence.mongo.repository.ProductMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductMongoRepository mongoRepository;
    private final ProductMapper mapper;


    @Transactional
    @Override
    public Product save(Product product) {
        ProductEntity productEntity = mapper.toEntityFromDomain(product);
        ProductEntity savedEntity = mongoRepository.save(productEntity);
        return mapper.toDomainFromEntity(savedEntity);
    }

    @Override
    public Pagination<Product> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> jpaPage = mongoRepository.findAll(pageable);
        return new Pagination<>(
                jpaPage.getContent().stream()
                        .map(mapper::toDomainFromEntity)
                        .toList(),
                jpaPage.getNumber(),
                jpaPage.getSize(),
                jpaPage.getTotalElements()
        );
    }

    @Override
    public boolean existsByName(String name) {
        return mongoRepository.existsByName(name);
    }
}

package com.joel.products.application.mapper;

import com.joel.products.application.commands.CreateProductCommand;
import com.joel.products.application.dtos.request.CreateProductRequestDTO;
import com.joel.products.application.dtos.response.ProductResponseDTO;
import com.joel.products.domain.entities.Product;
import com.joel.products.infrastructure.adapters.persistence.mongo.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMapper {

    public CreateProductCommand toCreateCommandFromDto(CreateProductRequestDTO requestDTO) {
        return CreateProductCommand.builder()
                .name(requestDTO.getName())
                .description(requestDTO.getDescription())
                .price(requestDTO.getPrice())
                .build();
    }

    public ProductResponseDTO toDtoFromDomain(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public ProductEntity toEntityFromDomain(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public Product toDomainFromEntity(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .build();
    }

    public Product toDomainFromCommand(CreateProductCommand createProduct) {
        return Product.builder()
                .id(UUID.randomUUID().toString())
                .name(createProduct.name())
                .description(createProduct.description())
                .price(createProduct.price())
                .build();
    }

}

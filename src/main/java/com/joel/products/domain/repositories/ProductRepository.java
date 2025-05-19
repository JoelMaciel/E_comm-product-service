package com.joel.products.domain.repositories;

import com.joel.products.domain.entities.Product;

public interface ProductRepository {

    Product save(Product product);

    boolean existsByName(String name);
}

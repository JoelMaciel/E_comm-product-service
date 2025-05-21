package com.joel.products.domain.repositories;

import com.joel.products.domain.entities.Product;
import com.joel.products.domain.pagination.Pagination;

public interface ProductRepository {

    Product save(Product product);

    Pagination<Product> findAll(int pageNumber, int size);

    boolean existsByName(String name);
}

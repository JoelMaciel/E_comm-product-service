package com.joel.products.application.ports.usecases.products;

import com.joel.products.domain.entities.Product;
import com.joel.products.domain.pagination.Pagination;

public interface ListProductUseCase {

    Pagination<Product> execute(int page, int size);
}

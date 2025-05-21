package com.joel.products.application.adapters.impl;

import com.joel.products.application.ports.usecases.products.ListProductUseCase;
import com.joel.products.domain.entities.Product;
import com.joel.products.domain.pagination.Pagination;
import com.joel.products.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListProductUseCaseImpl implements ListProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Pagination<Product> execute(int page, int size) {
        return productRepository.findAll(page, size);
    }
}

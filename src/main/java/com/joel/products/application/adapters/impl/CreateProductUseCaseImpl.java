package com.joel.products.application.adapters.impl;

import com.joel.products.application.commands.CreateProductCommand;
import com.joel.products.application.mapper.ProductMapper;
import com.joel.products.application.ports.usecases.products.CreateProductUseCase;
import com.joel.products.domain.entities.Product;
import com.joel.products.domain.exceptions.NameAlreadyExistsException;
import com.joel.products.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Transactional
    @Override
    public Product execute(CreateProductCommand createProductCommand) {
        validateName(createProductCommand);

        Product product = mapper.toDomainFromCommand(createProductCommand);
        Product savedProduct = productRepository.save(product);
        log.info("Product created with id: {}  ", savedProduct);
        return savedProduct;
    }

    private void validateName(CreateProductCommand createProductCommand) {
        boolean nameAlreadyExists = productRepository.existsByName(createProductCommand.name());
        if (nameAlreadyExists) {
            throw new NameAlreadyExistsException();
        }
    }

}

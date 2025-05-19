package com.joel.products.application.ports.usecases.products;

import com.joel.products.application.commands.CreateProductCommand;
import com.joel.products.domain.entities.Product;

public interface CreateProductUseCase {

    Product execute(CreateProductCommand createProductCommand);
}

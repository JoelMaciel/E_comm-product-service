package com.joel.products.infrastructure.adapters.api.controllers;

import com.joel.products.application.commands.CreateProductCommand;
import com.joel.products.application.dtos.request.CreateProductRequestDTO;
import com.joel.products.application.dtos.response.ProductResponseDTO;
import com.joel.products.application.mapper.ProductMapper;
import com.joel.products.application.ports.usecases.products.CreateProductUseCase;
import com.joel.products.domain.entities.Product;
import com.joel.products.infrastructure.adapters.api.swagger.ProductApiDocumentation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController implements ProductApiDocumentation {

    private final CreateProductUseCase createProductUseCase;
    private final ProductMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO createProduct(@RequestBody @Valid CreateProductRequestDTO createProductRequestDTO) {
        CreateProductCommand createCommand = mapper.toCreateCommandFromDto(createProductRequestDTO);
        Product product = createProductUseCase.execute(createCommand);
        return mapper.toDtoFromDomain(product);
    }

}

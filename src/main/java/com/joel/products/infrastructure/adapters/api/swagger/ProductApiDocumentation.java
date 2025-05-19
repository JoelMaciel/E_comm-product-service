package com.joel.products.infrastructure.adapters.api.swagger;

import com.joel.products.application.dtos.request.CreateProductRequestDTO;
import com.joel.products.application.dtos.response.ProductResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product API", description = "API for product management")
public interface ProductApiDocumentation {

    @Operation(
            summary = "Creates a new product",
            description = "Records a new product in the system with the data provided"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Product created with success"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid data provided"
            )
    })
    ProductResponseDTO createProduct(CreateProductRequestDTO createProductRequestDTO);
}
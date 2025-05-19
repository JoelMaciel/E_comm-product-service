package com.joel.products.application.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateProductRequestDTO {

    @NotBlank
    @Size(min = 3, max = 60)
    private String name;

    @NotBlank
    @Size(min = 10, max = 200)
    private String description;

    @NotNull
    @PositiveOrZero
    private BigDecimal price;
}

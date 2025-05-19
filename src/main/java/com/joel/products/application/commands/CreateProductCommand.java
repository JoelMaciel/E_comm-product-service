package com.joel.products.application.commands;

import lombok.Builder;
import java.math.BigDecimal;

@Builder
public record CreateProductCommand(
        String name,
        String description,
        BigDecimal price
) {
}

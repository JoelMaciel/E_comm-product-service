package com.joel.products.domain.entities;


import lombok.*;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}

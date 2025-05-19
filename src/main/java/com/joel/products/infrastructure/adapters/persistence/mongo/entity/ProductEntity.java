package com.joel.products.infrastructure.adapters.persistence.mongo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document(value = "products")
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}

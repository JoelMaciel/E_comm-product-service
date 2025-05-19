package com.joel.products.domain.exceptions;

public class ProductNotFoundException extends EntityNotFoundException{

    public ProductNotFoundException() {
        super("Product not registered in the database");
    }
}

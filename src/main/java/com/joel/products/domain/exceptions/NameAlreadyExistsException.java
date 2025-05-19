package com.joel.products.domain.exceptions;


public class NameAlreadyExistsException extends EntityInUseException {

    public NameAlreadyExistsException() {
        super("There is already a product registered with this username");
    }
}

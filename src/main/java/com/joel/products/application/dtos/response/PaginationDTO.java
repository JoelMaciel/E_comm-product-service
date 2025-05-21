package com.joel.products.application.dtos.response;

import java.util.List;

public record PaginationDTO<T>(
        List<ProductResponseDTO> content,
        int page,
        int size,
        long totalElements) {

}

package com.joel.products.domain.pagination;

import java.util.List;

public record Pagination<T>(
        List<T> content,
        int page,
        int size,
        long totalElements
) {
}

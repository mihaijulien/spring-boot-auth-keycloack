package io.mihaijulien.library_management_api.model.dto;

import io.mihaijulien.library_management_api.model.entity.BookCategory;
import lombok.Builder;

@Builder
public record BookDto (
        Long id,
        String title,
        String description,
        int copies,
        int copiesAvailable,
        BookCategory bookCategory,
        String img){ }

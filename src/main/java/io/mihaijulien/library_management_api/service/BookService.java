package io.mihaijulien.library_management_api.service;

import io.mihaijulien.library_management_api.model.dto.BookDto;

import java.util.List;

public interface BookService {
    public List<BookDto> getAllBooks();
}

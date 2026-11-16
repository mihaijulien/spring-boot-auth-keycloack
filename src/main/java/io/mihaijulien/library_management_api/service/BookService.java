package io.mihaijulien.library_management_api.service;

import io.mihaijulien.library_management_api.model.dto.BookDto;
import org.springframework.data.domain.Page;

public interface BookService {
    Page<BookDto> getAllBooks(int pageNo, int pageSize);
    BookDto getBookById(Long id);
    BookDto addBook(BookDto bookDto);
}

package io.mihaijulien.library_management_api.service;

import io.mihaijulien.library_management_api.model.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
}

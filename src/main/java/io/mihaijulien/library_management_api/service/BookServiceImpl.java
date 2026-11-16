package io.mihaijulien.library_management_api.service;

import io.mihaijulien.library_management_api.mapper.BookMapper;
import io.mihaijulien.library_management_api.model.dto.BookDto;
import io.mihaijulien.library_management_api.model.entity.Book;
import io.mihaijulien.library_management_api.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public List<BookDto> getAllBooks() {
        var books = bookRepository.findAll();
        return books.stream().map(BookMapper::toDto).toList();
    }
}

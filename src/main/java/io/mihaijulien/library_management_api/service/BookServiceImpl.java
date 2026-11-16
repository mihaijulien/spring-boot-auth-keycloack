package io.mihaijulien.library_management_api.service;

import io.mihaijulien.library_management_api.mapper.BookMapper;
import io.mihaijulien.library_management_api.model.dto.BookDto;
import io.mihaijulien.library_management_api.model.entity.Book;
import io.mihaijulien.library_management_api.repository.BookRepository;
import io.mihaijulien.library_management_api.service.exception.BookNotFoundException;
import io.mihaijulien.library_management_api.service.exception.ErrorMessage;
import io.mihaijulien.library_management_api.service.exception.InvalidBookException;
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

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(ErrorMessage.BOOK_NOT_FOUND.getValue()));;
        return BookMapper.toDto(book);
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        if(bookDto == null){
            throw new InvalidBookException(ErrorMessage.MISSING_BOOK.getValue());
        }

        Book savedBook = BookMapper.fromDto(bookDto);
        bookRepository.save(savedBook);

        return bookDto;
    }
}

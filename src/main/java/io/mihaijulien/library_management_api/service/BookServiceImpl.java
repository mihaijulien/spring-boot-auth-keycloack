package io.mihaijulien.library_management_api.service;

import io.mihaijulien.library_management_api.mapper.BookMapper;
import io.mihaijulien.library_management_api.model.dto.BookDto;
import io.mihaijulien.library_management_api.model.entity.Book;
import io.mihaijulien.library_management_api.repository.BookRepository;
import io.mihaijulien.library_management_api.service.exception.BookNotFoundException;
import io.mihaijulien.library_management_api.service.exception.ErrorMessage;
import io.mihaijulien.library_management_api.service.exception.InvalidBookException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Page<BookDto> getAllBooks(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return bookRepository.findAll(pageable).map(BookMapper::toDto);
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

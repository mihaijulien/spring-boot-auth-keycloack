package io.mihaijulien.library_management_api.repository;

import io.mihaijulien.library_management_api.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

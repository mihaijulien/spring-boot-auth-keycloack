package io.mihaijulien.library_management_api.repository;

import io.mihaijulien.library_management_api.model.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    /*** Spring Data Pattern ***/

    // select * from review where book_id = "bookId"
    List<Review> findAllByBookId(Long bookId);

    Page<Review> findByBookId(Long bookId, Pageable pageable);

    boolean existsByUserEmailAndBookId(String userEmail, Long bookId);

    /** @Query() + JPQL **/

    @Query("from Review r where r.bookId = :bookId")
    List<Review> searchByBookId(@Param("bookId") Long bookId);


    /** @Query() + SQL native  **/

    @Query(value = "select * from review where book_id = :bookId", nativeQuery = true)
    List<Review> searchByBookIdNative(Long bookId);
}

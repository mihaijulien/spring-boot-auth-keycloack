package io.mihaijulien.library_management_api.service;

import io.mihaijulien.library_management_api.model.dto.ReviewDto;
import io.mihaijulien.library_management_api.model.entity.Review;
import io.mihaijulien.library_management_api.repository.ReviewRepository;
import io.mihaijulien.library_management_api.service.exception.ReviewAlreadyExistsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Page<ReviewDto> getReviewsByBookId(Long bookId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return reviewRepository.findByBookId(bookId, pageable).map(ReviewDto::toDto);
    }

    @Override
    public ReviewDto createReview(String userEmail, ReviewDto reviewDto) {
        if (reviewRepository.existsByUserEmailAndBookId(userEmail, reviewDto.bookId())){
            throw new ReviewAlreadyExistsException("Review already exists for this user");
        }

        Review savedReview = ReviewDto.fromDto(reviewDto);
        savedReview.setUserEmail(userEmail);

        return ReviewDto.toDto(reviewRepository.save(savedReview));
    }
}

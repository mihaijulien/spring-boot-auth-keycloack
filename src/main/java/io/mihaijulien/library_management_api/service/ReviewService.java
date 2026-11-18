package io.mihaijulien.library_management_api.service;

import io.mihaijulien.library_management_api.model.dto.ReviewDto;
import org.springframework.data.domain.Page;

public interface ReviewService {

    Page<ReviewDto> getReviewsByBookId(Long bookId, int pageNo, int pageSize);
    ReviewDto createReview(String userEmail, ReviewDto reviewDto);
}

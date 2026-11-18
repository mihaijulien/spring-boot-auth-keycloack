package io.mihaijulien.library_management_api.model.dto;

import io.mihaijulien.library_management_api.model.entity.Review;
import lombok.Builder;

import java.util.Date;

@Builder
public record ReviewDto(
        double rating,
        Long bookId,
        String reviewDescription
) {

    public static Review fromDto(ReviewDto dto){
        return Review.builder()
                .rating(dto.rating())
                .bookId(dto.bookId())
                .reviewDescription(dto.reviewDescription())
                .build();
    }

    public static ReviewDto toDto(Review entity){
        return ReviewDto.builder()
                .rating(entity.getRating())
                .bookId(entity.getBookId())
                .reviewDescription(entity.getReviewDescription())
                .build();
    }

}

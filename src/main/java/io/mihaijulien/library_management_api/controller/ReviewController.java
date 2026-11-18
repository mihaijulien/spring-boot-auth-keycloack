package io.mihaijulien.library_management_api.controller;

import io.mihaijulien.library_management_api.model.dto.ReviewDto;
import io.mihaijulien.library_management_api.service.ReviewService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Page<ReviewDto>> getReviewsByBookId(
            @PathVariable Long bookId,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int pageSize){
        return new ResponseEntity<>(reviewService.getReviewsByBookId(bookId, pageNo, pageSize), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(
            @AuthenticationPrincipal Jwt jwt,
            @RequestBody ReviewDto reviewDto) {
        //  get the user’s email from the authenticated JWT
        String userEmail = jwt.getClaimAsString("email");
        return new ResponseEntity<>(reviewService.createReview(userEmail, reviewDto), HttpStatus.CREATED);
    }
}

package com.hoteldream.review;

import com.hoteldream.domain.Review;

import com.hoteldream.domain.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;
    private final Review review;

    public Review createReview(ReviewForm reviewForm) {
        Review review = modelMapper.map(reviewForm, Review.class);
        review.setReview_date(LocalDate.now());
        Review newReview = reviewRepository.save(review);

        return newReview;
    }


    public List<Review> getAllReview(Pageable pageable) {
        List<Review> reviewlist = new ArrayList<>();
        reviewRepository.findAll(pageable).forEach(review -> reviewlist.add(review));
        return reviewlist;
    }
    //성구
    public List<ReviewForm> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ReviewForm convertToDto(Review review) {
        return new ModelMapper().map(review, ReviewForm.class);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    //악플
    public List<ReviewForm> getReportedReviews() {
        List<Review> reportedReviews = reviewRepository.findByReport(1);
        return reportedReviews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}


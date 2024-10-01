package com.kiran.review.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.review.Review;
import com.kiran.review.ReviewRepository;
import com.kiran.review.ReviewService;



@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private final ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		super();
		this.reviewRepository = reviewRepository;
	}

	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public boolean createReview(Long companyId, Review review) {
		if(companyId != null && review != null) {
			review.setCompanyId(companyId);		
			reviewRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public Review getReviewById(Long reviewId) {
		return reviewRepository.findById(reviewId).orElse(null);
		
	}

	@Override
	public boolean updateReviewById(Long reviewId, Review updatedReview) {
		Review review = reviewRepository.findById(reviewId).orElse(null);
		if(review != null) {
			review.setTitle(updatedReview.getTitle());
			review.setDescription(updatedReview.getDescription());
			review.setRating(updatedReview.getRating());
			review.setCompanyId(updatedReview.getCompanyId());
			reviewRepository.save(updatedReview);
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean deleteReviewById(Long reviewId) {
		Review review = reviewRepository.findById(reviewId).orElse(null);
		if(review != null) {
			reviewRepository.delete(review);
			return true;
		} else {
			return false;
		}
		
	}

}

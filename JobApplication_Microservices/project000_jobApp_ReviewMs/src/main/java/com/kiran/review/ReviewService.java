package com.kiran.review;

import java.util.List;

public interface ReviewService {
	List<Review> getAllReviews(Long companyId);

	boolean createReview(Long companyId, Review review);

	Review getReviewById(Long reviewId);

	boolean updateReviewById(Long reviewId, Review review);

	boolean deleteReviewById(Long reviewId);

}

package com.kiran.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	public ReviewController() {
		super();
	}

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}
	
	@GetMapping
	public ResponseEntity<List<Review>> getAllReviews(@RequestParam("companyId") Long companyId){
		List<Review> allReviews = reviewService.getAllReviews(companyId);
		return new ResponseEntity<List<Review>>(allReviews, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addReview(@RequestParam("companyId") Long companyId, @RequestBody Review review){
		boolean isReviewAdded = reviewService.createReview(companyId, review);
		if(isReviewAdded) {
			return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Review not added successfully", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{reviewId}")
	public ResponseEntity<Review> getReviewById( @PathVariable("reviewId") Long reviewId){
		Review review = reviewService.getReviewById(reviewId);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}
	
	@PutMapping("/{reviewId}")
	public ResponseEntity<String> updateReviewById( @PathVariable("reviewId") Long reviewId, @RequestBody Review review){
		boolean isReviewUpdated = reviewService.updateReviewById(reviewId, review);
		if(isReviewUpdated) {
			return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Review not updated successfully", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<String> deleteReviewById(@PathVariable("reviewId") Long reviewId){
		boolean isReviewDeleted = reviewService.deleteReviewById(reviewId);
		if(isReviewDeleted) {
			return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Review not deleted successfully", HttpStatus.NOT_FOUND);
		}
	}
}

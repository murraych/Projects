package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Beer;
import com.techelevator.model.Review;

public interface ReviewDAO {

	List<Review> getAllReviewsByTargetId(int targetId);
	void createReview(Review newReview);
	Review getReviewByReviewId(int reviewId);
	void updateUpdateReview(Review review);
	void deleteReview(int reviewId);
	List<Review> getAllReviewsByUserId(int userId);
	List<Beer> topRatedBeers();
	int deleteReviews(int userId);
}

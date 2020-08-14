package com.techelevator.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ReviewDAO;
import com.techelevator.model.Beer;
import com.techelevator.model.Review;

@RestController
@CrossOrigin
public class ReviewController {

	@Autowired
	ReviewDAO reviews;
	
	@GetMapping(path="/breweries/reviews/{targetId}")
	public List<Review> getReviewsByBreweryId(@PathVariable int targetId) {
		List<Review> allReviews = reviews.getAllReviewsByTargetId(targetId);
		return allReviews;
	}
	
	@GetMapping(path="/reviews/users/{userId}") //<-- since userID in review made string this endpoint won't work! we can delete this if not needed
	public List<Review> getReviewsByUserId(@PathVariable int userId){
		List<Review> userReviews = reviews.getAllReviewsByUserId(userId);
		return userReviews;
	}
	
	@PostMapping(path="/reviews")
	@ResponseStatus(HttpStatus.CREATED)
	public void createReview(@RequestBody Review newReview) {
		reviews.createReview(newReview);
	}
	
	@PutMapping(path="/editReview")
	@ResponseStatus(HttpStatus.OK)
	public void updateReview(@RequestBody Review review) {
		reviews.updateUpdateReview(review);
	}
	
	@DeleteMapping(path="/deleteReview/{id}")
	public void deleteReview(@PathVariable int id) {
		reviews.deleteReview(id);
	}
	
	@DeleteMapping(path="/reviews/{userId}/delete")
	public void deleteReviews(@PathVariable int userId) {
		reviews.deleteReviews(userId);
	}
	
	
	// List top reviews on home page-- make a home controller? currently just prints id, name, brewery_id, gluten_free, avg_rating of top 5 beers
	@GetMapping(path="/reviews/toprated")
	public List<Beer> listTopBeers(){
		List<Beer> tops = reviews.topRatedBeers();
		return tops;
	}
}

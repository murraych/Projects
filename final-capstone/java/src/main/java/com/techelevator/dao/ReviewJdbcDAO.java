package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Beer;
import com.techelevator.model.Review;

@Component
public class ReviewJdbcDAO implements ReviewDAO {
	private JdbcTemplate template;
	
	public ReviewJdbcDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<Review> getAllReviewsByTargetId(int targetId) {
		List<Review> reviewList = new ArrayList<>();	
		String sqlGetAllBrews = "SELECT reviews.id, reviews.user_id, review_type, target_id, review_title, review_body, review_caps, "
				+ "users.username FROM reviews JOIN users ON reviews.user_id = users.user_id WHERE target_id = ?";
		SqlRowSet results = template.queryForRowSet(sqlGetAllBrews, targetId);
		while(results.next()) {
			Review aReview = mapRowToReviews(results);
			reviewList.add(aReview);
		}
		return reviewList;
	}
	
	@Override
	public List<Review> getAllReviewsByUserId(int userId){
		List<Review> aUserReviews = new ArrayList<>();
		String sqlReviews = "SELECT * FROM reviews WHERE user_id = ?";
		SqlRowSet results = template.queryForRowSet(sqlReviews, userId);
		while(results.next()) {
			Review aReview = mapRowToReviews(results);
			aUserReviews.add(aReview);
		}
		return aUserReviews;		
	}
	
	@Override
	public List<Beer> topRatedBeers(){ //<-- ask: what information do we want to send to the front other than ones on line 51!
											// description maps to avg_rating
		List<Beer> tops = new ArrayList<>();
		String sqlTopReviews = "SELECT beers.brewery_id, beers.id, name, gluten_free,  SUM(reviews.review_caps)/COUNT(review_caps) AS avg_rating FROM reviews "
				+ "JOIN beers ON reviews.target_id = beers.id WHERE review_type = 1 GROUP BY beers.id, beers.name ORDER BY avg_rating DESC LIMIT 5";
		SqlRowSet result = template.queryForRowSet(sqlTopReviews);
		while(result.next()) {
			Beer beer = mapRowToBeer(result);
			tops.add(beer);
		}
		return tops;
	}
	
	@Override
	public void createReview(Review newReview) {
		String sqlInsertNewReview = "INSERT INTO reviews(review_type, target_id, user_id, review_title, review_body, review_caps)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		template.update(sqlInsertNewReview, newReview.getReviewTypeId(), newReview.getTargetId(), newReview.getUserId(), newReview.getReviewTitle(),
				newReview.getReviewBody(), newReview.getReviewCaps());				
	}
	
	@Override
	public Review getReviewByReviewId(int reviewId) {
		String sqlGetAreview = "SELECT * FROM reviews WHERE id=?";
		SqlRowSet result = template.queryForRowSet(sqlGetAreview);
		result.next();
		Review theReview = mapRowToReviews(result);
		return theReview;
	}
	
	@Override
	public void updateUpdateReview(Review review) {
		String sqlUpdateNewReview = "UPDATE reviews SET review_type=?, target_id=?, user_id=?, review_title=?, review_body=?, review_caps=?"
				+ "WHERE id=?";
		template.update(sqlUpdateNewReview, review.getReviewTypeId(), review.getTargetId(), review.getUserId(), review.getReviewTitle(),
				review.getReviewBody(), review.getReviewCaps(), review.getId());
	}
	
	@Override
	public void deleteReview(int reviewId) {
		String sqlDeleteBrewery = "DELETE FROM reviews WHERE id = ?";
		template.update(sqlDeleteBrewery, reviewId);
	}
	
	@Override
	public int deleteReviews(int userId) {
		String deleteUserReviews = "DELETE FROM reviews WHERE user_id = ?";
		int reviewsDeleted = template.update(deleteUserReviews, userId);
		return reviewsDeleted;
	}
	
	private Review mapRowToReviews(SqlRowSet row) {
		Review rev = new Review();
		rev.setId(row.getInt("id"));
		rev.setReviewBody(row.getString("review_body"));
		rev.setReviewCaps(row.getInt("review_caps"));
		rev.setReviewTitle(row.getString("review_title"));
		rev.setReviewTypeId(row.getInt("review_type"));
		rev.setTargetId(row.getInt("target_id"));
		rev.setUsername(row.getString("username"));
		rev.setUserId(row.getInt("user_id"));
		
		return rev;
	}
	

	private Beer mapRowToBeer(SqlRowSet result) {
		    Beer theBeer = new Beer();
		    theBeer.setId(result.getInt("id"));
		    theBeer.setBreweryId(result.getInt("brewery_id"));
		    theBeer.setName(result.getString("name"));
		    theBeer.setGlutenFree(result.getBoolean("gluten_free"));
		    theBeer.setDescription(result.getString("avg_rating"));
		    return theBeer;
		}
}

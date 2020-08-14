package com.techelevator.dao;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Review;

public class ReviewJdbcDAOTest extends DAOIntegrationTest {

	private JdbcTemplate template;
	private ReviewJdbcDAO reviewDao;
	private static int REVIEW_ID_BREWERY;
	private static int TARGET_ID_BREW;
	private static int REVIEW_ID_BEER;
	private static int TARGET_ID_BEER;
	private static int USER_ID;

	@Before
	public void setup() {
		DataSource dataSource = this.getDataSource();
		template = new JdbcTemplate(dataSource);
		reviewDao = new ReviewJdbcDAO(template);
		Review testRev = new Review();
		REVIEW_ID_BREWERY = 2;
		TARGET_ID_BREW = 100;
		REVIEW_ID_BEER = 1;
		TARGET_ID_BEER = 1000;
		USER_ID = 3;
		// insert a dummy brewery
		String createTestBrewery = "INSERT INTO breweries(id, name) VALUES(100,'TEST')";
		template.update(createTestBrewery);
		// insert a dummy beer to dummy brewery
		String addAbeer = "INSERT INTO beers(id, name, brewery_id, beer_type) VALUES(1000, 'Greatest Beer', 100, 131)";
		template.update(addAbeer);
		//insert dummy review
		String sqlInsertDummyBrewery = "INSERT INTO REVIEWS(review_type, target_id, user_id, review_title,"
				+ "review_body, review_caps) VALUES(?, ?, ?, ?, ?, ?)";
		template.update(sqlInsertDummyBrewery, REVIEW_ID_BREWERY, TARGET_ID_BREW, USER_ID, "WOW",
				"IT IS A GREAT BREWERY", 5);
		String sqlInsertDummyBeer = "INSERT INTO REVIEWS(review_type, target_id, user_id, review_title,"
				+ "review_body, review_caps) VALUES(?, ?, ?, ?, ?, ?)";
		template.update(sqlInsertDummyBeer, REVIEW_ID_BEER, TARGET_ID_BEER, USER_ID, "WOW",
				"GREAT TASTE", 5);
	}

	@Test
	public void getAllReviewsByTargetIdTestBreweryReview() {
		String sqlGetCount = "SELECT COUNT(*) FROM reviews JOIN users ON reviews.user_id = users.user_id"
				+ " WHERE target_id = ?";
		SqlRowSet result = template.queryForRowSet(sqlGetCount, TARGET_ID_BREW);
		result.next();
		assertEquals(result.getInt(1), reviewDao.getAllReviewsByTargetId(TARGET_ID_BREW).size());	
		assertEquals(TARGET_ID_BREW, reviewDao.getAllReviewsByTargetId(TARGET_ID_BREW).get(0).getTargetId());
		assertEquals("WOW", reviewDao.getAllReviewsByTargetId(TARGET_ID_BREW).get(0).getReviewTitle());
		assertEquals("IT IS A GREAT BREWERY", reviewDao.getAllReviewsByTargetId(TARGET_ID_BREW).get(0).getReviewBody());
	}
	
	@Test
	public void getAllReviewsByTargetIdTestBeerReview() {
		String sqlGetCount = "SELECT COUNT(*) FROM reviews JOIN users ON reviews.user_id = users.user_id"
				+ " WHERE target_id = ?";
		SqlRowSet result = template.queryForRowSet(sqlGetCount, TARGET_ID_BEER);
		result.next();
		assertEquals(result.getInt(1), reviewDao.getAllReviewsByTargetId(TARGET_ID_BEER).size());	
		assertEquals(TARGET_ID_BEER, reviewDao.getAllReviewsByTargetId(TARGET_ID_BEER).get(0).getTargetId());
		assertEquals("WOW", reviewDao.getAllReviewsByTargetId(TARGET_ID_BEER).get(0).getReviewTitle());
		assertEquals("GREAT TASTE", reviewDao.getAllReviewsByTargetId(TARGET_ID_BEER).get(0).getReviewBody());
	}
	
	@Test
	public void getAllReviewsByUserId() {
		String sqlCount = "SELECT COUNT(*) FROM reviews JOIN users ON users.user_id = reviews.user_id WHERE user_id = ?";
		SqlRowSet result = template.queryForRowSet(sqlCount, USER_ID);
		result.next();
		System.out.println(reviewDao.getAllReviewsByUserId(USER_ID).size());
		//assertEquals(result.getInt(1), reviewDao.getAllReviewsByUserId(USER_ID).size());
		
	}

}

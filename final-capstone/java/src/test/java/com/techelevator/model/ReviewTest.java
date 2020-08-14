package com.techelevator.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReviewTest {

	private Review testReview;
	
	@Before
	public void setUp() {
		testReview = new Review();
	}
	
	
	@Test
	public void sameReviewsAreSame() {
		Review actual = new Review();
		assertEquals(testReview.getId(), actual.getId());
		assertEquals(testReview.getReviewTypeId(), actual.getReviewTypeId());
		assertEquals(testReview.getTargetId(), actual.getTargetId());
		assertEquals(testReview.getUserId(), actual.getUserId());
		assertEquals(testReview.getUsername(), actual.getUsername());
		assertEquals(testReview.getReviewTitle(), actual.getReviewTitle());
		assertEquals(testReview.getReviewBody(), actual.getReviewBody());
		assertEquals(testReview.getReviewCaps(), actual.getReviewCaps());
	}
	
	@Test
	public void diffReviewsAreDiff() {
		Review actual = new Review();
		actual.setReviewBody("Test");
		assertNotEquals(testReview, actual);
	}
}

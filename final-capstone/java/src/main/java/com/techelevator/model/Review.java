package com.techelevator.model;

public class Review {

//Date Members
	private int id;
	private int reviewTypeId;
	private int targetId;
	private int userId;
	private String username;
	private String reviewTitle;
	private String reviewBody;
	private int reviewCaps;
	
//Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReviewTypeId() {
		return reviewTypeId;
	}

	public void setReviewTypeId(int reviewTypeId) {
		this.reviewTypeId = reviewTypeId;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewBody() {
		return reviewBody;
	}

	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}

	public int getReviewCaps() {
		return reviewCaps;
	}

	public void setReviewCaps(int reviewCaps) {
		this.reviewCaps = reviewCaps;
	}
	

	
	
	
}

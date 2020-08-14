package com.techelevator.model;

public class Favorite {
	
//data members
	private int userId;
	private int breweryId;
	private String breweryName;
	
//getters and setters	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBreweryId() {
		return breweryId;
	}
	public void setBreweryId(int breweryId) {
		this.breweryId = breweryId;
	}
	
	public String getBreweryName() {
		return breweryName;
	}
	
	public void setBreweryName(String breweryName) {
		this.breweryName = breweryName;
	}
}

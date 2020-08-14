package com.techelevator.model;

public class Beer {
	
//Data Members
	private int id;
	private int breweryId;
	private String name;
	private String description;
	private String image;
	private double abv;
	private String beerType;
	private int beerTypeId;
	private boolean glutenFree;

	
//Constructors

//Getters and Setters

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBreweryId() {
		return breweryId;
	}
	public void setBreweryId(int breweryId) {
		this.breweryId = breweryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getAbv() {
		return abv;
	}
	public void setAbv(double abv) {
		this.abv = abv;
	}
	public String getBeerType() {
		return beerType;
	}
	public void setBeerType(String beerType) {
		this.beerType = beerType;
	}
	public int getBeerTypeId() {
		return beerTypeId;
	}
	public void setBeerTypeId(int beerTypeId) {
		this.beerTypeId = beerTypeId;
	}
	public boolean isGlutenFree() {
		return glutenFree;
	}
	public void setGlutenFree(boolean glutenFree) {
		this.glutenFree = glutenFree;
	}
	


}

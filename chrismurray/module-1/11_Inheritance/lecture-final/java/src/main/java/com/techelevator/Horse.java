package com.techelevator;

public class Horse {
	
	// data members
	private String breed;
	private String color;
	private int birthYear;
	
	// got rid of default constructor
	// added constructor that will set all the data members
	public Horse(String breed, String color, int birthYear) {
		this.breed = breed;
		this.color  = color; 
		this.birthYear = birthYear;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getBirthYear() {
		return birthYear;
	}


	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

}

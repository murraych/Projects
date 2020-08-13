package com.techelevator;

public abstract class Wall {
	
//Data Members
	
	private String color;
	private String name;

	
//Constructors
	public Wall(String name, String color) {
		this.name = name;
		this.color = color;
	}
	

//Methods
	
	public abstract int getArea();
	
//Getters and Setters

public String getColor() {
	return color;
}


public void setColor(String color) {
	this.color = color;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}



}

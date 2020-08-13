package com.techelevator;

public class RectangleWall extends Wall {
	
//Data Members
	
	private int height;
	private int length;
	
//Constructors
	
	public RectangleWall (String name, String color, int length, int height) {
		super(name, color);
		this.length = length;
		this.height = height;
	}
	
//Methods
	@Override //not sure if this is needed or not
	public int getArea() {
		return length * height;
	}
	
	public String toString() {
		return getName() + " (" + length + "x" + height + ") " + "rectangle";
	}
	
//Getters and Setters

public int getHeight() {
	return height;
}

public int getLength() {
	return length;
}



}

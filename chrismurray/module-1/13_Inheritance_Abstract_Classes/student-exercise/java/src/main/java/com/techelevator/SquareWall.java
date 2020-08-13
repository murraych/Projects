package com.techelevator;

public class SquareWall extends RectangleWall {
	
//Data Members
	
	private int sideLength;

	
//Constructors
	
	
	public SquareWall (String name, String color, int sideLength) {
		super(name, color, sideLength, sideLength);
		this.sideLength = sideLength;
	}
	
//Methods
	public String toString() {
		return getName() + " (" + sideLength + "x" + sideLength + ") " + "square";
	}

//Getters and Setters
	
	
	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}
	
	
	

}

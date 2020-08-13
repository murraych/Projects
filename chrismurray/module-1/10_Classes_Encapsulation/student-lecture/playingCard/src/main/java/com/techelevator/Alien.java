package com.techelevator;

public class Alien {

	// define characteristics of an alien -- data member, data variables, or
	// instance variables
	// these are always private
	private boolean isHostile;
	private int numberOfLimbs;
	private String skinColor;
	private String planetOfOrigin;
	private static String offWorld = "Outer Space";
	
	// Methods -- behaviors

	// Mutators -- also known as setters. They set the values into the data members
	public void setIsHostile(boolean isHostile) {
		this.isHostile = isHostile; // this means "this object"
									// this.hostile on the left side because youre stating on the right this boolean
									// (isHostile) is set to the object this isHostile.
	}

	// Accessor -- Getters -- they get (or return) the values from the data members
	public boolean getIsHostile() {
		return this.isHostile; // return the value associated with "this" object
	}

	public int getNumberOfLimbs() {
		return numberOfLimbs;
	}

	public void setNumberOfLimbs(int numberOfLimbs) {
		this.numberOfLimbs = numberOfLimbs;
	}

	public String getSkinColor() {
		return skinColor;
	}

	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}

	public String getPlanetOfOrigin() {
		return planetOfOrigin;
	}

	public void setPlanetOfOrigin(String planetOfOrigin) {
		this.planetOfOrigin = planetOfOrigin;
	}

}

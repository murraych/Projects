package com.techelevator.alien;

public class Alien {  /// Definition file -- defines the properties and behaviors of an Alien
	
	//  define characteristics of an Alien -- data member, data variables, or instance variables
	// these are always private
	private boolean isHostile;
	private int numberOfLimbs;
	private String skinColor;
	private String planetOfOrigin;
	
	public Alien() {
		this(false, 0, "green", "unknown");
	}
	
	public Alien(boolean isHostile, int numberOfLimbs, String skinColor, String planetOfOrigin) {
		this.isHostile = isHostile;
		if (numberOfLimbs  > 100) {
			this.numberOfLimbs = 100;
		} else {
			this.numberOfLimbs = numberOfLimbs;
		}
		this.skinColor = skinColor;
		this.planetOfOrigin = planetOfOrigin;
	}
	 
	public Alien(boolean isHostile, int numberOfLimbs) {
		this(isHostile, numberOfLimbs, "green", "unknown");  // "this" key word means call the constructor that matches
		                                            // within this class
	}
	
	// only one copy of this exists no matter how object we create
	public static String offWorld = "Outer Space";
	
	
	// Methods -- behaviors
	
	// Mutators -- Setters -- they set the values into the data members
	public void setIsHostile(boolean isHostile) {
		this.isHostile = isHostile;  // this means "this object"
	}
	
	// Accessors -- Getters -- they get (or return) the values from the data members
	public boolean getIsHostile() {
		return this.isHostile;  // return the value associated with "this" object
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
	
	@Override
	public String toString() {  // the original toString comes from the object class 
		return "Planet of Origin: " + planetOfOrigin +
				"\nSkin color: " + skinColor +
				"\nNumber of Limbs: " +
				 numberOfLimbs + "\nHostile? " +
				isHostile + "\n" + super.toString();
	}

}

package com.techelevator.farm;

import java.math.BigDecimal;

public class FarmAnimal implements Singable, Sellable{
	
	//implements says we are going to provide the 
	// method bodies for the methods from the Singable interface
	private String name;
	private String sound;
	
	// data member to hold the price of a Farm Animal object
	private BigDecimal price;

	public FarmAnimal(String name, String sound, BigDecimal price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	@Override  // -- @Override means the method provides body for
	     // the abstract method specified in Singable
	public String getName() {
		return name;
	}

	@Override
	public String getSound() {
		return sound;
	}
	
	@Override
	public String getSoundTwice() {
		return sound + " " + sound;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

}
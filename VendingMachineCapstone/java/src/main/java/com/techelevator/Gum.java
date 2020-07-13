package com.techelevator;

public class Gum extends Inventory {

	public Gum(String slotLocation, String productName, double price) {
		super(slotLocation, productName, price);
		
	}

	@Override
	public String getSound() {
		
		return "Chew Chew, Yum!";
	}

	
}

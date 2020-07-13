package com.techelevator;

public class Drink extends Inventory {

	public Drink(String slotLocation, String productName, double price) {
		super(slotLocation, productName, price);
		
	}

	@Override
	public String getSound() {
		
		return "Glug Glug, Yum!";
	}

}

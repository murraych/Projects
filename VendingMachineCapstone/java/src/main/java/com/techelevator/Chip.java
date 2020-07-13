package com.techelevator;

public class Chip extends Inventory{

	public Chip (String slotLocation, String productName, double price) {
		super(slotLocation, productName, price);
	}
	
	
	@Override
	public String getSound() {
		
		return "Crunch Crunch, Yum!";
	}
}

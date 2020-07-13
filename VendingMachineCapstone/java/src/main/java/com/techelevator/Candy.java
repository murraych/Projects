package com.techelevator;

public class Candy extends Inventory {

	public Candy(String slotLocation, String productName, double price) {
		super(slotLocation, productName, price);
		
	}

	@Override
	public String getSound() {
		
		return "Munch Munch, Yum!";
	}

}

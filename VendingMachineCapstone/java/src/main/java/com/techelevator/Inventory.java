package com.techelevator;

public abstract class Inventory {

	//Attributes
	private String productName;
	private String slotLocation;
	private double price;
	private int stock = 5;
		
	//Constructors
	public Inventory (String slotLocation, String productName, double price) {
		this.productName = productName;
		this.slotLocation = slotLocation;
		this.price = price;
		
	}

	
	//Getters and Setters
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSlotLocation() {
		return slotLocation;
	}

	public void setSlotLocation(String slotLocation) {
		this.slotLocation = slotLocation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//Methods
	public abstract String getSound();

	public void updateStock() {
		stock --;
	
	}
	

	
	
}

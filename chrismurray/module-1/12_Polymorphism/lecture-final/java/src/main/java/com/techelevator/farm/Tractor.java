package com.techelevator.farm;

public class Tractor implements Singable {

	private String color;


	@Override
	public String getName() {
		return "Tractor";
	}

	@Override
	public String getSound() {
		return "vroom!";
	}

	@Override
	public String getSoundTwice() {
		return "vroom! vroom!";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	

}

package com.techelevator.farm;

public class FarmAnimal{
	private String name;
	private String sound;
	
	//new data member
	private boolean isAsleep;


	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		isAsleep = false; // default is the animal is awake
	}

	
	public void sleep() {
		isAsleep = true;
		sound = "Zzzzz...";
	}
	
	public final String getSound() { //final means this method cannot be overridden
		return sound;
	}
	public String getName() {
		return name;
	}
	



}
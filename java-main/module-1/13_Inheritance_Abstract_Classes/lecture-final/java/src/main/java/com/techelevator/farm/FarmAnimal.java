package com.techelevator.farm;

public abstract class FarmAnimal{
	
	/*
	 * abstract class is one that can have
	 * data members and concrete method
	 * but also has an abstract method
	 * (one that all children must override)
	 */
	private String name;
	private String sound;
	
	//new data member
	private boolean isAsleep;


	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		isAsleep = false;  // default is the animal is awake
	}

	public void sleep() {
		isAsleep = true;
		sound = "Zzzzz...";
	}
	
	
	// final means this method cannot be overridden
	public final String getSound() {
		return sound;
	}
	public String getName() {
		return name;
	}
	
	
	// abstract method and all children must override
	// what does it mean to eat as a child class?
	//public abstract String eat();


}
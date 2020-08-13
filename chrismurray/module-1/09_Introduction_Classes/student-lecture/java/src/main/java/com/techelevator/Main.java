package com.techelevator;			//package
public class Main {					//class
	
	static String animal = "Dog";			//properties - internal variables
	
	static String animalSound = "Woof";
	
	static int animalSpeed = 20;
	
	
	//CTOR - constructor

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Scanner to get command
		
		bark(); // method call
		move();
		
		
		
	}
	
	// Public Methods
	
	public static void bark() {
		System.out.println(animalSound);
	}
	
	public static void move() {
		System.out.println("I run at: " + animalSpeed + " per second");
		
		
	}

}

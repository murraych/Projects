package com.techelevator;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal myDog = new Animal("Paisley", "Ahhwooo");
		
		myDog.speak();
		
		System.out.println(myDog.name);
		
		Animal dogTwo = new Animal("Woof");
		
		myDog.move(50);
		
		System.out.println("Is " + myDog.name + " now asleep?" + myDog.getIsSleeping());
		
		
		myDog.move(80);
		
		System.out.println("Is " + myDog.name + " now asleep?" + myDog.getIsSleeping());

	}
	


}

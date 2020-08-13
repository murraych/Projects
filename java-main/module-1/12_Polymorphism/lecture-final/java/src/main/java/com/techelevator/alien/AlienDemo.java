package com.techelevator.alien;

public class AlienDemo {

	public static void main(String[] args) {

		Alien cylon = new Alien();
		
		// put data into data member of cylon object of type Alien
		cylon.setIsHostile(true);
		cylon.setNumberOfLimbs(4);
		cylon.setPlanetOfOrigin("Unknown");
		cylon.setSkinColor("Silver");
		
//		printAlienInformation(cylon, "Cylon");
//		System.out.println(Alien.offWorld);
		
		System.out.println(cylon);
		Alien martian = new Alien();
		martian.setIsHostile(false);
		martian.setNumberOfLimbs(4);
		martian.setPlanetOfOrigin("Mars");
		martian.setSkinColor("green");
		
		System.out.println(martian.toString());
	//	printAlienInformation(martian, "Martian");
		
		
		Alien alien3 = new Alien(true, 125);
		System.out.println("\n\n" + alien3);
	}
	
	public static void printAlienInformation(Alien obj, String type) {
		// Echoing back out 
				System.out.println("\nAlien:  " + type + "\n" +
				       "Planet of Origin: " + obj.getPlanetOfOrigin() +
				       "\nSkin Color:  " + obj.getSkinColor() +
				       "\nNumber of Limbs:  " + obj.getNumberOfLimbs() +
				       "\nHostile? " + obj.getIsHostile());
	}

}  // ends class

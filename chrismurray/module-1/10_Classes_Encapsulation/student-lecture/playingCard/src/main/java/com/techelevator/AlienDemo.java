package com.techelevator;

public class AlienDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alien cylon = new Alien();

		// put data into data member of cylon object of type Alien
		cylon.setIsHostile(true);
		cylon.setNumberOfLimbs(4);
		cylon.setPlanetOfOrigin("Unknown");
		cylon.setSkinColor("Silver");

		printAlienInformation(cylon, "Cylon");

		Alien martian = new Alien();
		martian.setIsHostile(false);
		martian.setNumberOfLimbs(4);
		martian.setPlanetOfOrigin("Mars");
		martian.setSkinColor("green");

		printAlienInformation(martian, "Martian");
		
		
		Card c = new Card("hearts", 5);
		System.out.println(c.toString());
		c.turnOver();
		System.out.println(c.toString());

	}

	public static void printAlienInformation(Alien obj, String type) {
		System.out.println(
				"Alien: " + type + "\n" + "Planet: " + obj.getPlanetOfOrigin() + "\nSkin Color: " + obj.getSkinColor()
						+ "\nNumber of Limbs: " + obj.getNumberOfLimbs() + "\nHostile? " + obj.getIsHostile());
	}

}

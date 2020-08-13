package com.techelevator;

public class HorseDemoApp {

	public static void main(String[] args) {

		//Horse horse1 = new Horse();  // first "I am a horse"
//		horse1.setBreed("Appaloosa");
//		horse1.setBirthYear(2010);
//		horse1.setColor("White and black");
		
		Horse horse1 = new Horse("Appaloosa", 
				"White and black", 2010);
		
		RaceHorse horse2 = new RaceHorse();  // parent constructor called first "I am a horse" then prints" I am a racehorse"
//		horse2.setBirthYear(2015);
//		horse2.setBreed("Arabian");
//		horse2.setColor("Brown");
//		horse2.setNumberOfRaces(12);
//		horse2.setJockey("Fred");
		
		System.out.println("Horse 1 Information: ");
		System.out.println("Breed: " + horse1.getBreed() +
				"\n   Birth Year: " + horse1.getBirthYear() +
				"\n   Color:  " + horse1.getColor());
		
		System.out.println("Horse 2 information: ");
		System.out.println("Breed: " + horse2.getBreed() +
				"\n   Birth Year: " + horse2.getBirthYear() +
				"\n   Color:  " + horse2.getColor() +
				"\n   Number of Races: " + horse2.getNumberOfRaces() +
				"\n   Jockey:  " + horse2.getJockey());	

		RaceHorse horse3 = new RaceHorse("Arabian", "Brown", 2015, 12, "Fred");
		
		System.out.println("Horse 3 information: ");
		System.out.println("Breed: " + horse3.getBreed() +
				"\n   Birth Year: " + horse3.getBirthYear() +
				"\n   Color:  " + horse3.getColor() +
				"\n   Number of Races: " + horse3.getNumberOfRaces() +
				"\n   Jockey:  " + horse3.getJockey());
	}

}

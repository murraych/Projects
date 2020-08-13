package com.techelevator.moduleOneReview;

public class DogDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Dog fido = new Dog(); //creates an object of type dog. new dog instantiates dog with humanyears, breed, fur color, and is sleeping
		
		Dog rex = new Dog();
		
		fido.setBreed("Poodle");
		System.out.println(fido.getFurColor());
		
		rex.setBreed("German Shepherd");
		
		Dog princess = new Dog(6, "Maltese");
		System.out.println("Human age " + 
		princess.getHumanYears() + 
		" and dog age " + 
		princess.getDogYears());
		
		
	}

}

package com.techelevator;

public class Animal {
	
		//* ***************************************************************************************
	    // * Private Variables (or Members)
	    // * ***************************************************************************************
		
		private int ageInMonths = 0;
		
		private String type = "";
		private int energyLevel = 100;
		private String sound = "";
		private Boolean isSleeping = false;
		
			
     	// ***************************************************************************************
		// Public Properties (or Members)
		// ***************************************************************************************


		public String name = "no name given";
		
		// ***************************************************************************************
		// Derived Properties
		// ***************************************************************************************

		
		public String formalName() {
			
			return "The Amazing " + name + ", a " + type;
		}
		
		public int ageInYears() {
			return ageInMonths/12;
		}
		
		// ***************************************************************************************
		// Accessors: Gettor and settor methods
		// ***************************************************************************************	
		
		public void setAge(int ageInMonths) {
			
			this.ageInMonths = ageInMonths;
		}
		
		public Boolean getIsSleeping() {
			return this.isSleeping;
		}
		

		// ***************************************************************************************
		// CTOR - Constructor(s)
		// ***************************************************************************************


		public Animal() {
			
			type = "Mammal";
			
		}
		
		public Animal(String name) {
			
			this.name = name;
			
		}
		
		public Animal(String name, String sound) {
			this.name = name;
			this.sound = sound;
		}
		
		
		// ***************************************************************************************
		// Public Methods
		// ***************************************************************************************

		
		public void speak() {
			System.out.println(this.sound);
		}
		
		public void move(int distanceInFeet) {
			this.energyLevel = this.energyLevel - (distanceInFeet/5);
			if(this.energyLevel < 80) {
				sleep();
			}
		}
		
		// ***************************************************************************************
		// Private Methods
		// ***************************************************************************************


		private void sleep() {
			this.isSleeping = true;
		}
}

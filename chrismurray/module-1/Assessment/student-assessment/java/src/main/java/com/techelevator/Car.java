package com.techelevator;

public class Car {

<<<<<<< HEAD
//Data Members

	private int year;
	private String make;
	private boolean isClassic;

// Derived

	public int getAge() {
		return 2020 - year;
	}

// Constructor

	public Car(int year, String make, boolean isClassic) {
		this.year = year;
		this.make = make;
		this.isClassic = isClassic;

	}

// Methods	

	public boolean doesCarNeedECheck(int yearToCheck) {

		int age = getAge();

		if (isClassic) {
			return false;
		}

		if (age < 4 || age > 25) {
			return false;
		} 
		else if ((year % 2 == 0 && yearToCheck % 2 == 0) || (year % 2 != 0 && yearToCheck != 0)) {
			return true;
		} else return false;

	}

	public String toString() {
		return "CAR - " + year + " - " + make;
	}

// Getters and Setters	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public boolean isClassic() {
		return isClassic;
	}

	public void setClassic(boolean isClassic) {
		this.isClassic = isClassic;
=======
	public Car() {
		// TODO Auto-generated constructor stub
>>>>>>> 1f43ebb505aa1a44b9fbf1892b4fb493948168b3
	}

}

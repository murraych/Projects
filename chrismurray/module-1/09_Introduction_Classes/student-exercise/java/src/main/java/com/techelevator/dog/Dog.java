package com.techelevator.dog;

public class Dog {
	
//	private boolean isSleeping = false;  ******Does this accomplish the same as the code below to set dogs awake by default? Do I need the CTOR below?
//
//
//		
//	}
	
	
	
private boolean isSleeping;

public Dog() {
	this.isSleeping = false;
}

public boolean isSleeping() {
	return isSleeping;
}
	

public String makeSound() {
	if (isSleeping) {
		return "Zzzzz...";
	}
	else return "Woof!";
}

public void sleep() {
	isSleeping = true;
}

public void wakeUp() {
	isSleeping = false;
}
	
}

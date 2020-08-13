package com.techelevator;

public class Calculator {

	public Calculator() {
		
	}
	
	public int add(int a, int b) {
		return (a + b);
	}

	public double add(double a, double b) {
		return (a + b);
	}
	
	public int subtract(int a, int b) {
		return (a - b);
	}
	
	public double subtract(double a, double b) {
		return (a - b);
	}
	
	
	public boolean inRange(int a) {
		if (a >= 10 && a <= 20) {
			return true;
		}
		return false;
	}
	
}

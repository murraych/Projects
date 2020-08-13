package com.techelevator;

public class Fraction {

// data members for fraction class	
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	@Override
	public boolean equals(Object o) {
		Fraction f = (Fraction)o;
		if (numerator == f.numerator && denominator == f.denominator) {
			return true;
		}
		return false;
	}

}

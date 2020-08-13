package com.techelevator;

public class Fraction {

	// data members for fraction class
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		// how to calculate the GCD is b
		int gcd = gcd (numerator, denominator);
		this.numerator = this.numerator / gcd;
		this.denominator = this.denominator / gcd;
		
	}

	@Override  // means overriding the Object version
	public boolean equals(Object o) {
		Fraction f = (Fraction) o; // convert to fraction
		
		if (numerator == f.numerator  &&
			denominator == f.denominator) {
			return true;
		}
			
		return false;
	}
	
	public int gcd(int num, int den) {
		num = Math.abs(num);
		den = Math.abs(den);
		while (num != den) {
			if (num > den) {
				num = num - den;
			} else {
				den = den - num;
			}
		}
		return num;  // this returns the gcd
	}
	
	public Fraction multiply(Fraction f) {
		return new Fraction (this.numerator * f.numerator,
				this.denominator * f.denominator);
	}
	
	public Fraction add(Fraction f) {
		if (this.denominator == f.denominator) {
			return new Fraction(this.numerator + f.numerator, 
				this.denominator);
		} else {
			int newDenom = this.denominator * f.denominator;  // 4 * 6=24
			int thisNum = this.numerator * f.denominator;  // 3 * 6 =18
			int fNum = f.numerator * this.denominator;  //5 * 4=20
			return new Fraction (thisNum + fNum, newDenom);  //38/24
		}
	}
	
	public Fraction divide (Fraction f) {
		
		// a/b / c/d  =>  a*d / b*c
		return new Fraction(this.numerator * f.denominator, 
				this.denominator * f.numerator);

	}
	
}

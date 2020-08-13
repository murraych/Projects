package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testEquals() {
		assertEquals(new Fraction(1, 2), 
			new Fraction(1, 2));
		
//   Above assertEquals is equavalent to below code
//		Fraction f1 = new Fraction(1,2);
//		Fraction f2 = new Fraction (1,2);
//		assertTrue(f1.equals(f2));
	}
	
	@Test
	public void testNotEquals() {
		assertNotEquals(new Fraction(1,2),
			new Fraction(1,3));
	}
	
	@Test
	public void testEquivalentFractionsNotReduced() {
		assertEquals(new Fraction(1,2), 
			new Fraction(2,4));
	}
	
	@Test
	public void testMultiply() {
		Fraction f1 = new Fraction(1, 2); // 1/2 * 3/4
		Fraction f2 = new Fraction(3, 4);
		Fraction expected = new Fraction(3, 8);  // 3/8
		assertEquals(expected, f1.multiply(f2));
	}
	
	@Test
	public void testAddTwoFractionsofSameDenominator() {
		// if 3/4 + 3/4 = 6/4
		Fraction f1 = new Fraction(3,4);
		Fraction f2 = new Fraction(3,4);
		Fraction expected = new Fraction(6, 4);
		assertEquals(expected, f1.add(f2));
	}
	
	@Test
	public void testAddTwoFractionsOfDifferentDenominator() {
		// 3/4 + 5/6 = 9/12 + 10/12 = 19/12
		Fraction f1 = new Fraction(3,4);
		Fraction f2 = new Fraction(5,6);
		Fraction expected = new Fraction (19,12);
		
		assertEquals(expected, f1.add(f2));
	}
	
	@Test
	public void testDivideTwoFractions() {
		// 3/4 / 3/4  => 1/1
		Fraction f1 = new Fraction(3,4);
		Fraction f2 = new Fraction (3,4);
		
		Fraction expected = new Fraction (1,1);
		
		assertEquals(expected, f1.divide(f2));
	}

}

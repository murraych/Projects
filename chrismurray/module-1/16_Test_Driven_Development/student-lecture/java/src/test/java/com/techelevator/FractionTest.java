package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testEquls() {
		assertEquals(new Fraction(1, 2), new Fraction(1,2));
	}
	
	@Test
	public void testNotEquals() {
		assertNotEquals(new Fraction(1, 2), new Fraction (1, 3));
		
	}
	
	

}

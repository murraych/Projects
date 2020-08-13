package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class SameFirstLastTest {

	SameFirstLast sameFirstLast = new SameFirstLast();
	
	@Test
	public void arrayIsVoid() {
		int nums[] = {};
		assertFalse(sameFirstLast.isItTheSame(nums));
		
	}
	
	@Test
	public void arrayLengthgreaterThan0() {
		int nums[] = {1, 2, 3};
		assertFalse(sameFirstLast.isItTheSame(nums));
		
	}
	
	@Test
	public void arrayLengthIs1() {
		int nums[] = {1};
		assertTrue(sameFirstLast.isItTheSame(nums));
		
	}
		
	@Test
	public void arrayIsNull() {
		int nums[] = null;
		assertFalse(sameFirstLast.isItTheSame(nums));
		
	}

}

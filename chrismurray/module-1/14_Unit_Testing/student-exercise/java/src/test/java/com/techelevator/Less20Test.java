package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Less20Test {

	Less20 less20 = new Less20();
	
	@Test
	public void oneLessMultipleOf20() {
		assertTrue(less20.isLessThanMultipleOf20(19));
	}
	
	@Test
	public void twoLessThankMultipleOf20() {
		assertTrue(less20.isLessThanMultipleOf20(18));
	}
	
	@Test
	public void notOneOrTwoLessMultipleOf20() {
		assertFalse(less20.isLessThanMultipleOf20(20));
	}

}

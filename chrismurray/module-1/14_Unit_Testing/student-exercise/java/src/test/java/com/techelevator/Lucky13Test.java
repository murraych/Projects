package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Lucky13Test {

	Lucky13 lucky13 = new Lucky13();
	
	
	@Test
	public void numsIsNull() {
		int nums[] = null;
		assertTrue(lucky13.getLucky(nums));
	}
	
	@Test
	public void numsIsNotNull() {
		int nums[] = {0, 2, 4};
		assertTrue(lucky13.getLucky(nums));
		
	}
	
	@Test
	public void threeIsIncluded() {
		int nums[] = {0, 2, 3};
		assertFalse(lucky13.getLucky(nums));

}
	
	@Test
	public void oneIsIncluded() {
		int nums[] = {1, 2, 4};
		assertFalse(lucky13.getLucky(nums));
	
}
	
}

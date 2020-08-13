package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxEnd3Test {

	MaxEnd3 myMaxEnd3 = new MaxEnd3();
	
	@Test
	public void testArrayPassesInIndex2LargestReturnAllIndex2Values() {
		
		int nums[] = {1, 2, 4};
		
		assertArrayEquals("4, 4, 4", new int[] {4, 4, 4}, myMaxEnd3.makeArray(nums));
		
	}
	
	@Test
	public void testMakeArrayPassesInIndex0LargestRetunAllIndex0Values() {
		int nums[] = {10, 8, 5};
		
		assertArrayEquals("10, 10, 10", new int[] {10, 10, 10}, myMaxEnd3.makeArray(nums));
		
		
	}
	
	@Test
	public void testMakeArrayPassesInIndex1LargestRetunAllIndex0Values() {
		int nums[] = {10, 800, 5};
		
		assertArrayEquals("10, 10, 10", new int[] {10, 10, 10}, myMaxEnd3.makeArray(nums));
		
		
	}

}
	


package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrontTimesTest {

	FrontTimes frontTimes = new FrontTimes();
	
	@Test
	public void stringLessOrEqualTo3() {
		assertEquals("ababab", frontTimes.generateString("ab", 3));
		assertEquals("AbcAbc", frontTimes.generateString("Abc", 2));
		assertEquals("aaa", frontTimes.generateString("a", 3));
		assertEquals("B", frontTimes.generateString("B", 1));
		assertEquals("", frontTimes.generateString("b", 0));
	}

	@Test
	public void stringIsNull() {
		assertEquals("", frontTimes.generateString("", 3));
	}
	
	@Test
	public void StringGreaterThan3() {
		assertEquals("ChoCho", frontTimes.generateString("Chocolate", 2));
		assertEquals("ChoChoCho", frontTimes.generateString("Chocolate", 3));
		assertEquals("Cho", frontTimes.generateString("Chocolate", 1));
		assertEquals("", frontTimes.generateString("Chocolate", 0));
	}
	
}

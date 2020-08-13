package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void add_method_adds_42_and_returns_77() {
		
		Calculator calculator = new Calculator();
		int a = 42;
		int b = 35;
		int actual = calculator.add(a, b);
		int expected = 77;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void add_method_adds_negative_values() {
		Calculator calculator = new Calculator();
		int a = -55;
		int b = -16;
		
		int actual = calculator.add(a, b);
		assertEquals(-71, actual);
	}
	
	@Test
	public void add_double_method() {
		Calculator calculator = new Calculator();
		double actual = calculator.add(5.66,  3.2);
		double delta = 0.00001; // how much the numbers can be off from each other and still be considered equal
		assertEquals(8.86, actual, delta);
		
	}
	
	@Test
	public void check_in_range() {
		Calculator calculator = new Calculator();
		assertTrue(calculator.inRange(15));
		
		assertFalse(calculator.inRange(25));
	}

}

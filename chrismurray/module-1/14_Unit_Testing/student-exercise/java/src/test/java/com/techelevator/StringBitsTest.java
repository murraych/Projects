package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBitsTest {

	StringBits stringBits = new StringBits();
	
	@Test
	public void stringIsEmpty() {
		assertEquals("", stringBits.getBits(""));
	}

	@Test
	public void stringIsOdd() {
		assertEquals("Hlo", stringBits.getBits("Hello"));
		assertEquals("H", stringBits.getBits("Hi"));
		assertEquals("Hello", stringBits.getBits("Heeololeo"));
		
	}

	
}

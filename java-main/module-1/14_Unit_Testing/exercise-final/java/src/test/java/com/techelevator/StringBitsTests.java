package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringBitsTests {
	/*
	Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
	stringBits("Hello") → "Hlo"
	stringBits("Hi") → "H"
	stringBits("Heeololeo") → "Hello"
	*/
	
	@Test
	public void Null_ExpectEmptyString() {
		//Assert
		StringBits exercises = new StringBits();

		//Arrange
		assertEquals("", exercises.getBits(null));
	}
	
	@Test
	public void StringLength0_ExpectEmptyString() {
		//Assert
		StringBits exercises = new StringBits();

		//Arrange
		assertEquals("", exercises.getBits(""));
	}

	@Test
	public void StringLength1_ExpectSameString() {
		//Assert
		StringBits exercises = new StringBits();

		//Arrange
		assertEquals("H", exercises.getBits("H"));
	}

	@Test
	public void StringLength2OrMore_ExpectAlternateLetters() {
		//Assert
		StringBits exercises = new StringBits();

		//Arrange
		assertEquals("Js", exercises.getBits("Josh"));
		assertEquals("Tc lvtr", exercises.getBits("Tech Elevator"));
	}

}
package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Less20Tests {

	/*
	     Return true if the given non-negative number is 1 or 2 less than a multiple of 20. So for example 38
	     and 39 return true, but 40 returns false.
	     (Hint: Think "mod".)
	     less20(18) → true
	     less20(19) → true
	     less20(20) → false
	 */

	@Test
	public void Within1LessTest_ExpectTrue() {
		//Arrange
		Less20 exercises = new Less20();

		//Assert
		assertEquals(true, exercises.isLessThanMultipleOf20(19));
		assertEquals(false, exercises.isLessThanMultipleOf20(21));
		assertEquals(true, exercises.isLessThanMultipleOf20(39));
		assertEquals(false, exercises.isLessThanMultipleOf20(41));
	}

	@Test
	public void Within2LessTest_ExpectTrue() {
		//Arrange
		Less20 exercises = new Less20();

		//Assert
		assertEquals(true, exercises.isLessThanMultipleOf20(18));
		assertEquals(false, exercises.isLessThanMultipleOf20(22));
		assertEquals(true, exercises.isLessThanMultipleOf20(38));
		assertEquals(false, exercises.isLessThanMultipleOf20(42));
	}

	@Test
	public void Within3Test_ExpectFalse() {
		//Arrange
		Less20 exercises = new Less20();

		//Assert
		assertEquals(false, exercises.isLessThanMultipleOf20(17));
		assertEquals(false, exercises.isLessThanMultipleOf20(23));
		assertEquals(false, exercises.isLessThanMultipleOf20(3));
		assertEquals(false, exercises.isLessThanMultipleOf20(37));
		assertEquals(false, exercises.isLessThanMultipleOf20(43));
	}

}
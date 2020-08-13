package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateFashionTests {

	/*
		You and your date are trying to get a table at a restaurant. The parameter "you" is the stylishness
		of your clothes, in the range 0..10, and "date" is the stylishness of your date's clothes. The result
		getting the table is encoded as an int value with 0=no, 1=maybe, 2=yes. If either of you is very
		stylish, 8 or more, then the result is 2 (yes). With the exception that if either of you has style of
		2 or less, then the result is 0 (no). Otherwise the result is 1 (maybe).
		dateFashion(5, 10) → 2
		dateFashion(5, 2) → 0
		dateFashion(5, 5) → 1
	*/

	@Test
	public void AtLeastOneDateNotStylish_DontGetTable() {
		//Arrange
		DateFashion exercises = new DateFashion();

		//Assert
		assertEquals(0, exercises.getATable(2, 2));
		assertEquals(0, exercises.getATable(0, 0));
		assertEquals(0, exercises.getATable(2, 7));
		assertEquals(0, exercises.getATable(2, 9));
	}

	@Test
	public void BothDatesStylish_MaybeGetTable() {
		//Arrange
		DateFashion exercises = new DateFashion();

		//Assert
		assertEquals(1, exercises.getATable(3, 3));
		assertEquals(1, exercises.getATable(7, 7));
		assertEquals(1, exercises.getATable(3, 7));
	}

	@Test
	public void EitherDateVeryStylish_AlwaysGetTable() {
		//Arrange
		DateFashion exercises = new DateFashion();

		//Assert
		assertEquals(2, exercises.getATable(8, 3));
		assertEquals(2, exercises.getATable(3, 8));
	}

}

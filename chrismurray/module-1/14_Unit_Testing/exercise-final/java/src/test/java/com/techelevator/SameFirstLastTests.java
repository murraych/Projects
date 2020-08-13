package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SameFirstLastTests {

    /*
     Given an array of ints, return true if the array is length 1 or more, and the first element and
     the last element are equal.
     sameFirstLast([1, 2, 3]) → false
     sameFirstLast([1, 2, 3, 1]) → true
     sameFirstLast([1, 2, 1]) → true
     */

	@Test
    public void Null_ExpectFalse() {
        //Arrange
        SameFirstLast exercises = new SameFirstLast();

        //Assert
        assertEquals(false, exercises.isItTheSame(null));
    }
	
    @Test
    public void ArrayLength0_ExpectFalse() {
        //Arrange
        SameFirstLast exercises = new SameFirstLast();

        //Assert
        assertEquals(false, exercises.isItTheSame(new int[] {}));
    }

    @Test
    public void ArrayLength1_ExpectTrue() {
        //Arrange
        SameFirstLast exercises = new SameFirstLast();

        //Assert
        assertEquals(true, exercises.isItTheSame(new int[] { 1 }));
    }

    @Test
    public void ArrayLength2OrMore() {
        //Arrange
        SameFirstLast exercises = new SameFirstLast();

        //Assert
        assertEquals(true, exercises.isItTheSame(new int[] { 1, 1 }));
        assertEquals(true, exercises.isItTheSame(new int[] { 1, 3, 1 }));
        assertEquals(false, exercises.isItTheSame(new int[] { 1, 3 }));
        assertEquals(false, exercises.isItTheSame(new int[] { 1, 3, 3 }));

    }

}

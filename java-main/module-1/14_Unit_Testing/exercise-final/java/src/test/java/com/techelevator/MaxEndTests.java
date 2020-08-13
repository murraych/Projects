package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertArrayEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaxEndTests {

    /*
     Given an array of ints length 3, figure out which is larger between the first and last elements
     in the array, and set all the other elements to be that value. Return the changed array.
     maxEnd3([1, 2, 3]) → [3, 3, 3]
     maxEnd3([11, 5, 9]) → [11, 11, 11]
     maxEnd3([2, 11, 3]) → [3, 3, 3]
     */

    @Test
    public void EndLargerTest() {
        //Arrange
        MaxEnd3 exercises = new MaxEnd3();

        assertArrayEquals(new int[] { 3, 3, 3 }, exercises.makeArray(new int[] { 1, 0, 3 }));
        assertArrayEquals(new int[] { 3, 3, 3 }, exercises.makeArray(new int[] { 1, 10, 3 }));
    }

    @Test
    public void BeginningLargerTest() {
        //Arrange
        MaxEnd3 exercises = new MaxEnd3();

        //Assert
        assertArrayEquals(new int[] { 13, 13, 13 }, exercises.makeArray(new int[] { 13, 0, 3 }));
        assertArrayEquals(new int[] { 13, 13, 13 }, exercises.makeArray(new int[] { 13, 20, 3 }));

    }

    @Test
    public void EndSameSizesTest() {
        //Arrange
        MaxEnd3 exercises = new MaxEnd3();

        //Assert
        assertArrayEquals(new int[] { 10, 10, 10 }, exercises.makeArray(new int[] { 10, 0, 10 }));
        assertArrayEquals(new int[] { 10, 10, 10 }, exercises.makeArray(new int[] { 10, 20, 10 }));
    }

}
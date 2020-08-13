package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lucky13Tests {
    /*
     Given an array of ints, return true if the array contains no 1's and no 3's.
     GetLucky([0, 2, 4]) → true
     GetLucky([1, 2, 3]) → false
     GetLucky([1, 2, 4]) → false
     */
	
    @Test
    public void Null_ExpectTrue() {
        //Arrange
        Lucky13 lucky = new Lucky13();

        //Assert
        assertEquals(true, lucky.getLucky(null));
    }

    @Test
    public void ArrayWithNo1sOr0s_ExpectTrue() {
        //Arrange
        Lucky13 lucky = new Lucky13();

        //Assert
        assertEquals(true, lucky.getLucky(new int[] { 0, 2, 4 }));
        assertEquals(true, lucky.getLucky(new int[] {}));
    }

    @Test
    public void ArrayWithAll1sOr0s_ExpectFalse() {
        //Arrange
        Lucky13 lucky = new Lucky13();

        //Assert
        assertEquals(false, lucky.getLucky(new int[] { 1, 1, 1 }));
        assertEquals(false, lucky.getLucky(new int[] { 3, 3, 3 }));
        assertEquals(false, lucky.getLucky(new int[] { 1, 3 }));
    }
    
}
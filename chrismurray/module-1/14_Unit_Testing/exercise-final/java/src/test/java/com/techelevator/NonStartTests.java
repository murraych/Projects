package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NonStartTests {

    /*
     Given 2 strings, return their concatenation, except omit the first char of each. The strings will
     be at least length 1.
     nonStart("Hello", "There") → "ellohere"
     nonStart("java", "code") → "avaode"
     nonStart("shotl", "java") → "hotlava"
     */

    @Test
    public void FullStrings_ExpectNormalConcatenation() {
        //Arrange
        NonStart exercises = new NonStart();

        //Assert
        assertEquals("ihere", exercises.getPartialString("Hi", "There"));
    }

    @Test
    public void PartialStrings_ExpectPartialConcatenation() {
        //Arrange
        NonStart exercises = new NonStart();

        //Assert
        assertEquals("here", exercises.getPartialString("", "There"));
        assertEquals("i", exercises.getPartialString("Hi", ""));

    }
}

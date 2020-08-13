package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FrontTimesTests {

    /*
         Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or
         whatever is there if the string is less than length 3. Return n copies of the front;
         frontTimes("Chocolate", 2) → "ChoCho"
         frontTimes("Chocolate", 3) → "ChoChoCho"
         frontTimes("Abc", 3) → "AbcAbcAbc"
     */

    @Test
    public void StringGreaterThan3Tests() {
        //Arrange
        FrontTimes exercise = new FrontTimes();

        //Assert
        assertEquals("JosJosJos", exercise.generateString("Josh", 3));
        assertEquals("JosJos", exercise.generateString("Josh", 2));
        assertEquals("Jos", exercise.generateString("Josh", 1));
    }

    @Test
    public void StringLessThan3Tests() {
        //Arrange
        FrontTimes exercise = new FrontTimes();

        //Assert
        assertEquals("JoJoJo", exercise.generateString("Jo", 3));
        assertEquals("JoJo", exercise.generateString("Jo", 2));
        assertEquals("Jo", exercise.generateString("Jo", 1));
    }

    @Test
    public void EmptyStringTests() {
        //Arrange
        FrontTimes exercise = new FrontTimes();

        //Assert
        assertEquals("", exercise.generateString("", 3));
        assertEquals("", exercise.generateString("", 2));
        assertEquals("", exercise.generateString("", 1));
    }
    
    @Test
    public void NullTests() {
        //Arrange
        FrontTimes exercise = new FrontTimes();

        //Assert
        assertEquals("", exercise.generateString(null, 3));
        assertEquals("", exercise.generateString(null, 2));
        assertEquals("", exercise.generateString(null, 1));
    }

}

package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WordCountTests {

    /*
     * Given an array of strings, return a Dictionary<string, int> with a key for each different string, with the value the
     * number of times that string appears in the array.
     *
     * ** A CLASSIC **
     *
     * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
     * wordCount([]) → {}
     * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
     *
     */

	 @Test
	    public void Null_ExpectEmptySet() {
	        //Arrange
	        WordCount exercises = new WordCount();

	        //Assert
	        assertEquals(new HashMap<String, Integer>(), exercises.getCount(null));
	    }
	
    @Test
    public void EmptySetTest_ExpectEmptySet() {
        //Arrange
        WordCount exercises = new WordCount();

        //Assert
        assertEquals(new HashMap<String, Integer>(), exercises.getCount(new String[] {}));
    }

    @Test
    public void UniqueTest_Expect1Each() {
        //Arrange
        WordCount exercises = new WordCount();

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Josh", 1);
        expected.put("David", 1);
        expected.put("Casey", 1);
        expected.put("Craig", 1);

        //Assert
        assertEquals(expected, exercises.getCount(new String[] { "Josh", "David", "Casey", "Craig" }));
    }

    @Test
    public void RepeatingTest() {
        //Arrange
        WordCount exercises = new WordCount();

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Josh", 4);

        //Assert
        assertEquals(expected, exercises.getCount(new String[] { "Josh", "Josh", "Josh", "Josh" }));
    }

    @Test
    public void WordNotProvidedTests() {
        //Arrange
        WordCount exercises = new WordCount();

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Josh", 4);

        //Assert
        assertNotEquals(expected, exercises.getCount(new String[] { "Craig", "Craig", "Craig", "Craig" }));
    }
}

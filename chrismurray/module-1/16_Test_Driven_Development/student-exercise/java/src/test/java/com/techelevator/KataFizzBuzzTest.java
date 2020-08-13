package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataFizzBuzzTest {

	KataFizzBuzz myKataFizzBuzz = new KataFizzBuzz();
	
	@Test
	public void ifNumberIsDivisbleBy3OrContains3ConvertToFizz() {
		assertEquals("Fizz", myKataFizzBuzz.fizzBuzz(3));
		assertEquals("Fizz", myKataFizzBuzz.fizzBuzz(13));
		assertEquals("Fizz", myKataFizzBuzz.fizzBuzz(27));
		assertEquals("Fizz", myKataFizzBuzz.fizzBuzz(23));
	}
	
	@Test
	public void ifNumberIsDivisibleBy5OrContains5ConvertToBuzz() {
		assertEquals("Buzz", myKataFizzBuzz.fizzBuzz(5));
		assertEquals("Buzz", myKataFizzBuzz.fizzBuzz(51));
		assertEquals("Buzz", myKataFizzBuzz.fizzBuzz(20));
		
	}
	
	
	@Test
	public void ifNumberIsDivisbleBy3And5OrIncludes3And5ReturnFizzBuzz() {
		assertEquals("FizzBuzz", myKataFizzBuzz.fizzBuzz(15));
		assertEquals("FizzBuzz", myKataFizzBuzz.fizzBuzz(53));
		assertEquals("FizzBuzz", myKataFizzBuzz.fizzBuzz(35));
	}
	
	@Test
	public void numbersBetween1And100() {
		assertEquals("22", myKataFizzBuzz.fizzBuzz(22));
	}
	
	@Test
	public void numbersOutside1And100() {
		assertEquals("", myKataFizzBuzz.fizzBuzz(0));
		
	}
	
}

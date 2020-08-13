package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataFizzBuzzTest {

	@Test
	public void fizzBuzz_0_Test() {
		KataFizzBuzz kfb = new KataFizzBuzz();
		assertEquals("KataFizzBuzz(0)", "", kfb.fizzBuzz(0));
	}

	@Test
	public void fizzBuzz_101_Test() {
		KataFizzBuzz kfb = new KataFizzBuzz();
		assertEquals("KataFizzBuzz(101)", "", kfb.fizzBuzz(101));
	}

	@Test
	public void fizzBuzz_Obvious_Cases_Test() {
		KataFizzBuzz kfb = new KataFizzBuzz();
		assertEquals("KataFizzBuzz(3)", "Fizz", kfb.fizzBuzz(3));
		assertEquals("KataFizzBuzz(5)", "Buzz", kfb.fizzBuzz(5));
		assertEquals("KataFizzBuzz(6)", "Fizz", kfb.fizzBuzz(6));
		assertEquals("KataFizzBuzz(9)", "Fizz", kfb.fizzBuzz(9));
		assertEquals("KataFizzBuzz(15)", "FizzBuzz", kfb.fizzBuzz(15));
		assertEquals("KataFizzBuzz(45)", "FizzBuzz", kfb.fizzBuzz(45));
	}

	@Test
	public void fizzBuzz_Non_Fizzy_Buzzy_Numbers_Test() {
		KataFizzBuzz kfb = new KataFizzBuzz();
		assertEquals("KataFizzBuzz(2)", "2", kfb.fizzBuzz(2));
		assertEquals("KataFizzBuzz(7)", "7", kfb.fizzBuzz(7));
		assertEquals("KataFizzBuzz(17)", "17", kfb.fizzBuzz(17));
		assertEquals("KataFizzBuzz(34)", "Fizz", kfb.fizzBuzz(34)); //Step 2: 34 contains a 3, so is now Fizz, not 34
		assertEquals("KataFizzBuzz(53)", "Buzz", kfb.fizzBuzz(53)); //Step 2: 53 contains a 5 and 3, but 5 is checked first, so Buzz
		assertEquals("KataFizzBuzz(86)", "86", kfb.fizzBuzz(86));
	}
}

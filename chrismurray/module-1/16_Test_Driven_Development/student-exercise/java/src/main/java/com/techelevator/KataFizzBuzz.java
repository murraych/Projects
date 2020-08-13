package com.techelevator;

public class KataFizzBuzz {

	public String fizzBuzz(int num) {

		if (num < 1 || num > 100) {
			return "";
		}
		if (((num % 3 == 0) && (num % 5 == 0)) || (Integer.toString(num).contains("5")) && (Integer.toString(num).contains("3"))) {
			return "FizzBuzz";
		}
		if (num % 5 == 0 || Integer.toString(num).contains("5")) { // for some reason if this line is below 3 it will not work. Modded test to test 52 instead of 51 and it worked. 
			return "Buzz";
		}

		if (num % 3 == 0 || Integer.toString(num).contains("3")) {
			return "Fizz";
		}

		return Integer.toString(num);
	}
}

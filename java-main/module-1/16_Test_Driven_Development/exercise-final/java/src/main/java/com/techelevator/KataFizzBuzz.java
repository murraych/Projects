package com.techelevator;

public class KataFizzBuzz {

	public static void main(String[] args) {
		KataFizzBuzz kfb = new KataFizzBuzz();
		for (int i = 1; i <= 100; i++) {
			System.out.println(kfb.fizzBuzz(i));
		}
	}

	public String fizzBuzz(int n) {
		if ((n < 1) || (n > 100)) {
			return "";
		}

		boolean isDivisibleBy5 = n % 5 == 0;
		boolean isDivisibleBy3 = n % 3 == 0;
		if (isDivisibleBy3 && isDivisibleBy5) {
			return "FizzBuzz";
		}
		if (isDivisibleBy5) {
			return "Buzz";
		}
		if (isDivisibleBy3) {
			return "Fizz";
		}
		// Step 2:
		// Add a final check to see if the number contains a 5 or 3 if it isn't divisible by 3 and/or 5
		String stringN = Integer.toString(n);
		if (stringN.contains("5")) {
			return "Buzz";
		}
		if (stringN.contains("3")) {
			return "Fizz";
		}
		return stringN;
	}
}

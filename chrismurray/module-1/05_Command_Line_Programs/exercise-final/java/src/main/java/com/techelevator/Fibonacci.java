package com.techelevator;

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println("Please enter the ");
		int limit = Integer.parseInt(args[0]);
		int previous = 0;
		System.out.print("0");

		// the first and last section of the for loop are optional.
		// Here, we do not do anything at the end of each iteration.
		for (int next = 1; next < limit;) {
			System.out.print(", " + next);
			int temp = previous + next;
			previous = next;
			next = temp;
		}
	}
}

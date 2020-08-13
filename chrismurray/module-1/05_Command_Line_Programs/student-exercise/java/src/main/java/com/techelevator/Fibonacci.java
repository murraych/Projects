//The Fibonacci numbers are the integers in the following sequence:
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
//
//By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two.
//
//Write a command line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number.
//Please enter the Fibonacci number: 25
//
//0, 1, 1, 2, 3, 5, 8, 13, 21


package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Please provide an integer: ");
		int integerInput = Integer.parseInt(input.nextLine());
		int nextNum = 1;
		int first = 0;
		int second = 1;
		
		System.out.print(first + ", " + second);
		
		while (nextNum <= integerInput) {
			System.out.print(", " + nextNum);
			nextNum = first + second;
			first = second;
			second = nextNum;
			
			
		}
		input.close();
		
	}

}

package com.techelevator.moduleOneReview;

import java.util.Scanner;

public class ReviewDemo {

	// up here we would create data member
	// outside of any method

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// variables
		int number1; // since we are in the main mehtod. we do not need private. we are not creating
						// dating members
		int number2;
		String choice = "";

		Scanner userInput = new Scanner(System.in); // Scanner object which is an instance of an object

		do { // do this block of code -- and must have down at the bottom a } while
				// (condition);
			System.out.println("Enter a number: ");
			number1 = Integer.parseInt(userInput.nextLine()); // do inside first (the nextLine), then turn into int.
																// this one line does waht both lines below do.

			System.out.println("Enter another number: ");
			String intStr = userInput.nextLine(); // get the userInput(always returns a string)
			number2 = Integer.parseInt(intStr); // convert the string to an int

			System.out.println("Choose your mathematical operator: ");
			System.out.println("A - add");
			System.out.println("S - subtract");
			System.out.println("M - multiply");
			System.out.println("D - divide");
			System.out.println("Q - quit");
			System.out.println("\nEnter choice");
			choice = userInput.nextLine().toUpperCase(); // takes input and converts it to upper case

			if (choice.startsWith("A")) { // checks ti see if an A
				int sum = number1 + number2;
				System.out.println(number1 + " + " + number2 + " = " + sum);
			} else if (choice.startsWith("S")) {
				int difference = number1 - number2;
				System.out.println(number1 + " - " + number2 + " = " + difference);
			} else if (choice.startsWith("M")) {
				int product = number1 * number2;
				System.out.println(number1 + " * " + number2 + " = " + product);
			} else if (choice.startsWith("D")) {
				int quotient = number1 / number2;
				System.out.println(number1 + " / " + number2 + " = " + quotient);
			}
		} while (!(choice.startsWith("Q")));
		
		//ask the user to enter a starting number
		// count down by 5's until we hit 0 -- print out the numbers
		
		int start = Integer.parseInt(userInput.nextLine());
				// for (init; condition; altering) -- condition is the only spot required (; must be there)
		for (;start >= 0 ; start -= 5) {
			System.out.println(start);
		}
		
		//while (condition) { while block}
		
		int num = 0; //init
		while (num < 10) { //num < 10 is the condition
			System.out.println(num);
			num++; //altering
		}
		
		userInput.close();
		
	
	}

}

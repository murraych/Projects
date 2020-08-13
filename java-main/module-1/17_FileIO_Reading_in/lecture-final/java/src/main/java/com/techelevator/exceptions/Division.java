package com.techelevator.exceptions;

import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numerator = 0, denominator = 0, result = 0;

		try {
			System.out.print("Enter numerator >> ");
			numerator = Integer.parseInt(input.nextLine());
//			do {
			System.out.print("Enter denominator >> ");
			denominator = Integer.parseInt(input.nextLine());
//			} while (denominator == 0);
			result = numerator / denominator;
		} catch (ArithmeticException e) {
			System.out.println("Divide by zero not allowed");
			result = numerator;
		} catch (NumberFormatException e) {
			System.out.println("Invalid number entered");
		} catch (Exception e) {
			System.out.println("Some general exception ocurred");
		}
		System.out.println(numerator + " / " + denominator + " = " + result);

		int[] myIntArray = new int[5];

		for (int i = 0; i < 5; i++) {
			try {
				System.out.print("Enter an integer: ");
				myIntArray[i] = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Not an integer, try again!");
				i--;  // decrement i because we are going increment
			}
		}
		
		for (int num: myIntArray) {
			System.out.println(num);
		}

	}

}

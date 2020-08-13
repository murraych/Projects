package com.techelevator.exceptions;

import java.util.Scanner;

public class Division {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numerator, denominator, result;
		
		System.out.print("Enter numerator >> ");
		numerator = Integer.parseInt(input.nextLine());
		
		System.out.print("Enter denominator >> ");
		denominator = Integer.parseInt(input.nextLine());
		
		result = numerator / denominator;
		
		System.out.println(numerator + " / " + denominator + " = " +
		result);

	}

}

package com.techelevator;

import java.util.Scanner;

public class MyFunProgram {

	public static void main(String[] args) {
		
		/*  This program will create an array of 5 prices.  We will
		 *  ask the user to enter 5 doubles, which we will load into the array
		 *  We will then ask for a discount percent, which we will apply to each 
		 *  price and print out the value after the discount
		 */
		
		double[] priceArray = new double[5];
		Scanner input = new Scanner(System.in);  // cntl-shift-o will fix imports for you
		
		System.out.println("Enter in 5 prices all on one line (separated by a space): ");
		String priceInput = input.nextLine();
		System.out.println("You entered: " + priceInput);
		
		String[] priceStrings = priceInput.split(" ");  // this line splits the priceInput into array elements
		
		for (int i = 0; i < priceStrings.length; i++) {
			priceArray[i] = Double.parseDouble(priceStrings[i]);
			System.out.println(priceArray[i]);
		}
		System.out.println("How much is the discount (enter whole number): ");
		int discount = Integer.parseInt(input.nextLine());  // WHAT???!!!!
//		String discStr = input.nextLine();
//		int disc = Integer.parseInt(discStr);
		
		System.out.println("After " + discount + "% discount:");
		for (int i = 0 ; i < priceArray.length; i++) {
			double afterDiscount = priceArray[i] * (1 - (double)discount / 100);  // Hint - integer math!
			System.out.println(afterDiscount);
		}
		input.close();

	}

}

package com.techelevator;

import java.util.Scanner;

public class MakeChange {
	/*
	Write a command line program which prompts the user for the total bill, and the amount tendered. It should then display the change required.
	
	C:\Users> MakeChange
	
	Please enter the amount of the bill: 23.65
	Please enter the amount tendered: 100.00
	The change required is 76.35
	*/
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.print("Please enter the amount of the bill: ");
		String inputBillAmount = userInput.nextLine();
		double amountOfBill = Double.parseDouble(inputBillAmount);

		System.out.print("Please enter the amount tendered: ");
		String inputTenderedAmount = userInput.nextLine();
		double amountTendered = Double.parseDouble(inputTenderedAmount);

		double changeRequired = amountTendered - amountOfBill;

		System.out.println("The change required is " + changeRequired);

	}

}

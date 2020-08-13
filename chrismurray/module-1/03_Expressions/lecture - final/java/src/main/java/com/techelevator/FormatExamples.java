package com.techelevator;

public class FormatExamples {

	public static void main(String[] args) {
		

		
		// ***********************
		// ESCAPE CHARACTERS
		// ***********************
		String emerilQuote = "Emeril said, \"Bam!\"";
		System.out.println(emerilQuote);
		
		System.out.println("To print \\ I need two backslashes"); 
		
		System.out.println("Hello!\n\nGoodbye!");  // The escape character for newline is \n
		
		System.out.println("Hello\tGoodbye"); // The escape character for tab is \t
	
		// printf and String.format
		double money = .25 + .1 + .05 * 2;
		System.out.println(money);
		System.out.printf("%.2f\n", money); // %.2f means 2 decimals places to the right of the decimal point
		System.out.println(55);
		
		System.out.printf("|%8.2f|\n", money);  // the 8 says print in a field of 8 characters wide
		
		System.out.printf("The amount of money is $%.2f.\n", money);
		System.out.printf("Name: %-20s money: $%.2f\n", "Mrs. Hilt", money); // -20 says left justify in a field of 20 chars
		System.out.printf("Name:%20s money: $%.2f\n", "Mrs. Hilt", money);
		
		double aDouble = 2.4567;
		System.out.printf("%f  %8.2f  %.3f",aDouble, money, money );
	}

}
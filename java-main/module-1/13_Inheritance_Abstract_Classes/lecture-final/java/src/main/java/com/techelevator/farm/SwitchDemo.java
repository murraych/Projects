package com.techelevator.farm;

import java.util.Scanner;

public class SwitchDemo {


	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		System.out.println("Movie Ticket Purchase");
		System.out.print("Enter quantity: ");
		int quantity = Integer.parseInt(input.nextLine());
		
		System.out.println("Type of ticket: ");
		System.out.println("A. Adult  - $14.00");
		System.out.println("C. Child  - $ 8.00");
		System.out.println("S. Senior - $ 11.00");
		System.out.print("Enter choice: ");
		String choice = input.nextLine().toUpperCase();
		double total = 0;
		switch (choice) {  // if (choice
		case "A": 	// == 1
			total = quantity * 14.00;  // do this
			// more statement
			break;
		case "C":       // else if (choice == 2)
			total = quantity * 8.00;   // do this
			break;
		case "S": case "s":    // else if (choice == 3)
			total = quantity * 11.00;  // do this
			break;
		default:    // for all other cases, do this
			System.out.println("Invalid entry");
				
		}
		System.out.println("Total due is " + total);

	}

}

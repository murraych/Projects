package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapApplication {

	/*
	 * Create a small application that uses a Map
	 * Requirements:
	 *   - Declare a Map
	 *   - Ask for user input to load the Map (initalize) 
	 *   - Ask user to enter a key and search Map and return value if found
	 *        , return message if not found
	 *   - Ask user to insert another map element.  If element already exists in Map, 
	 *        return a message stating this.
	 */
	public static void main(String[] args) {

		Map <String, String> namePassword = new HashMap<>();
		Scanner input = new Scanner(System.in);
		namePassword.put("Chris", "ChrisPassword");
		namePassword.put("Brandon", "BrandonPassword");
		namePassword.put("Kris", "KrisPassword");
		
		System.out.println("Please enter you Name and Password");
		String userInput = input.nextLine();
			
		
	}

}

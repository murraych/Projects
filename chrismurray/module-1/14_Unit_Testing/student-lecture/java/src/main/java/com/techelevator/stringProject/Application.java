package com.techelevator.stringProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Contains methods for string manipulation through the console
 *
 */
public class Application {

	/**
	 * Starts the console driven application.
	 */
	public void run() {

		Scanner userInput = new Scanner(System.in);
		String input;
		while (true) {
			System.out.println("Enter an option:\n" + "0: Quit.\n"
					+ "1: Break the string into substrings (words) using spaces as separators.\n"
					+ "2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n"
					+ "3: Count the unique occurences of each word using punctuation and spaces as separators.\n"
					+ "4: Convert vowels to uppercase and consonants to lowercase.\n" 
					+ "5: Convert to lowercase.");
			input = userInput.nextLine();

			if (input.equals("0")) {
				break;

			} else if (input.equals("1")) {
				subString(askForString(userInput));

			} else if (input.equals("2")) {
				charCount(askForString(userInput));

			} else if (input.equals("3")) {
				uniqueOccurrences(askForString(userInput));

			} else if (input.equals("4")) {
				vowelCase(askForString(userInput));

			} else if (input.equals("5")) {
				toLowercase(askForString(userInput));

			} else {
				System.out.println("Enter option 1-5, or 0 to quit.");
			}
			System.out.println();
		}
		userInput.close();

	}

	/**
	 * Requests a String from the console.
	 * 
	 * @param input is the console's input.
	 * @return a string for what was entered.
	 */
	protected String askForString(Scanner input) {
		String result = "";
		while (true) {
			System.out.println("Enter a string up to 1000 characters:");
			result = input.nextLine();
			if (result.length() > 1000) {
				System.out.println("String must be less than 1000 characters.");
			} else {
				break;
			}
		}
		return result;
	}

	/**
	 * Prints the input with a new line after each space.
	 * 
	 * @param val is the input String.
	 */
	protected void subString(String val) {
		StringTools input = new StringTools(val);
		String word = "";

		for (int i = 0; i < input.length(); i++) {
			if (input.getCharAt(i) == ' ') {
				System.out.println(word);
				word = "";

			} else {
				word += input.getCharAt(i);
			}
		}
	}

	/**
	 * Prints the count of alphabetic, numeric and other characters.
	 * 
	 * @param val is the input String.
	 */
	protected void charCount(String val) {
		StringTools input = new StringTools(val);

		int alphabeticCount = 0;
		int numericCount = 0;
		int otherCount = 0;

		for (int i = 0; i < input.length(); i++) {
			if (String.valueOf(input.getCharAt(i)).matches("\\d")) {
				numericCount++;

			} else if (String.valueOf(input.getCharAt(i)).matches("[a-z]")) {
				alphabeticCount++;

			} else if (String.valueOf(input.getCharAt(i)).matches("\\S")) {
				otherCount++;
			}
		}
		System.out.println("Alphabetic: " + alphabeticCount);
		System.out.println("Numeric: " + numericCount);
		System.out.println("Other: " + otherCount);
	}


	/**
	 * Prints every unique word in the input and the number of occurrences.
	 * 
	 * @param val is the input String.
	 */
	protected void uniqueOccurrences(String val) {

		LinkedHashMap<String, Integer> seen = new LinkedHashMap<String, Integer>();

		for (String word : val.split("([.,!?:;'\"-]|\\s)")) {

			if (seen.containsKey(word)) {
				seen.put(word, seen.get(word) + 1);

			} else {
				seen.put(word, 1);
			}
		}

		for (String w : seen.keySet()) {
			System.out.println(seen.get(w) + " " + w);
		}
	}

	/**
	 * Converts all vowels to uppercase and all consonants to lowercase.
	 * 
	 * @param val is the input String.
	 */
	protected void vowelCase(String val) {
		StringTools input = new StringTools(val);

		for (int i = 0; i < input.length(); i++) {
			char letter = input.getCharAt(i);

			switch (letter) {
			case ' ':
				System.out.print(' ');
				break;
			case 'A':
				System.out.print(letter);
				break;
			case 'E':
				System.out.print(letter);
				break;
			case 'I':
				System.out.print(letter);
				break;
			case 'O':
				System.out.print(letter);
				break;
			case 'U':
				System.out.print(letter);
				break;
			case 'a':
				System.out.print((char) (letter - 32));
				break;
			case 'e':
				System.out.print((char) (letter - 32));
				break;
			case 'i':
				System.out.print((char) (letter - 32));
				break;
			case 'o':
				System.out.print((char) (letter - 32));
				break;
			case 'u':
				System.out.print((char) (letter - 32));
				break;

			default:
				if (Character.isLowerCase(letter)) {
					System.out.print(letter);

				} else {
					System.out.print((char) (letter + 32));
				}
			}
		}
	}

	/**
	 * Prints the input in lower case letters.
	 * 
	 * @param val is the input String.
	 */
	protected void toLowercase(String val) {
		StringTools input = new StringTools(val);

		for (int i = 0; i < input.length(); i++) {
			char letter = input.getCharAt(i);

			if (String.valueOf(letter).matches("[A-Z]")) {
				System.out.print((char) (letter + 32));

			} else {
				System.out.print(letter);
			}
		}
	}
}

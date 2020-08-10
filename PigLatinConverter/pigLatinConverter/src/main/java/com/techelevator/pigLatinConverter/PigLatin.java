package com.techelevator.pigLatinConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("*******************************");
		System.out.println("**PIG LATIN CONVERTER**");
		System.out.println("*******************************");
		System.out.println();
		System.out.println("Please enter a sentence, without punctuation, you would like translated to Pig Latin.");

		// scan in user input. Split words by whitespace. Put indiviual words into an
		// array.
		String englishInput = scan.nextLine();
		String[] words = englishInput.split(" ");

		// create a list to hold words translated to Pig Latin
		List<String> pigLatin = new ArrayList();

		// loop through the english words in the words array and add yay to the end for
		// words beginning with a vowel
		for (String word : words) {
			char firstLetter = Character.toLowerCase(word.charAt(0));
			if (firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o'
					|| firstLetter == 'u') {
				pigLatin.add(word + "-yay");
			}

			// if the word begins with a consonant remove the first letter and append to the
			// end with ay
			else {

				String consonant = "";
				String vowel = "";
				for (int i = 0; i < word.length(); i++) {
					if (Character.toLowerCase(word.charAt(i)) != 'a' && Character.toLowerCase(word.charAt(i)) != 'e'
							&& Character.toLowerCase(word.charAt(i)) != 'i'
							&& Character.toLowerCase(word.charAt(i)) != 'o'
							&& Character.toLowerCase(word.charAt(i)) != 'u') {
						consonant += Character.toLowerCase(word.charAt(i));
					}
					if (Character.toLowerCase(word.charAt(i)) == 'a' || Character.toLowerCase(word.charAt(i)) == 'e'
							|| Character.toLowerCase(word.charAt(i)) == 'i'
							|| Character.toLowerCase(word.charAt(i)) == 'o'
							|| Character.toLowerCase(word.charAt(i)) == 'u') {
						vowel = word.substring(i);
						break;
					}
				}
				pigLatin.add(vowel + "-" + consonant + "ay");

			}
		}

		// loop through the list of pig latin words and print them out
		for (String word : pigLatin) {
			System.out.print(word + " ");
		}
		scan.close();
	}

}



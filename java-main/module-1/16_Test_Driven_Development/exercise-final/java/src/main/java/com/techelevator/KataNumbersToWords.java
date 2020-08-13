package com.techelevator;

public class KataNumbersToWords {

	private final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven", " eight",
			" nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen",
			" eighteen", " nineteen" };

	private final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy",
			" eighty", " ninety" };

	private final String[] specialNames = { "", " thousand", " million" };

	private String numberToWordsLessThanOneThousand(int number) {
		// Handle numbers less than 1000
		String words = "";
		if (number % 100 < 20) {
			words = numNames[number % 100];
			number /= 100;
		} else {
			words = numNames[number % 10];
			number /= 10;
			words = tensNames[number % 10] + words;
			number /= 10;
		}
		if (number == 0) {
			return words;
		}
		return numNames[number] + " hundred" + words;
	}

	public String numberToWords(int number) {
		if (number == 0) {
			return "zero";
		}
		String prefix = "";
		if (number < 0) {
			number = -number;
			prefix = "negative";
		}
		String current = "";
		int place = 0;
		do {
			int n = number % 1000;
			if (n != 0) {
				String s = numberToWordsLessThanOneThousand(n);
				current = s + specialNames[place] + current;
			}
			place++;
			number /= 1000;
		} while (number > 0);
		return (prefix + current).trim();
	}

	public int wordsToNumber(String words) {
		int number = 0;
		int finalNumber = 0;
		String[] valueWords = words.split(" ");
		for (String str : valueWords) {
			if ("zero".equalsIgnoreCase(str)) {
				number += 0;
			} else if ("one".equalsIgnoreCase(str)) {
				number += 1;
			} else if ("two".equalsIgnoreCase(str)) {
				number += 2;
			} else if ("three".equalsIgnoreCase(str)) {
				number += 3;
			} else if ("four".equalsIgnoreCase(str)) {
				number += 4;
			} else if ("five".equalsIgnoreCase(str)) {
				number += 5;
			} else if ("six".equalsIgnoreCase(str)) {
				number += 6;
			} else if ("seven".equalsIgnoreCase(str)) {
				number += 7;
			} else if ("eight".equalsIgnoreCase(str)) {
				number += 8;
			} else if ("nine".equalsIgnoreCase(str)) {
				number += 9;
			} else if ("ten".equalsIgnoreCase(str)) {
				number += 10;
			} else if ("eleven".equalsIgnoreCase(str)) {
				number += 11;
			} else if ("twelve".equalsIgnoreCase(str)) {
				number += 12;
			} else if ("thirteen".equalsIgnoreCase(str)) {
				number += 13;
			} else if ("fourteen".equalsIgnoreCase(str)) {
				number += 14;
			} else if ("fifteen".equalsIgnoreCase(str)) {
				number += 15;
			} else if ("sixteen".equalsIgnoreCase(str)) {
				number += 16;
			} else if ("seventeen".equalsIgnoreCase(str)) {
				number += 17;
			} else if ("eighteen".equalsIgnoreCase(str)) {
				number += 18;
			} else if ("nineteen".equalsIgnoreCase(str)) {
				number += 19;
			} else if ("twenty".equalsIgnoreCase(str)) {
				number += 20;
			} else if ("thirty".equalsIgnoreCase(str)) {
				number += 30;
			} else if ("forty".equalsIgnoreCase(str)) {
				number += 40;
			} else if ("fifty".equalsIgnoreCase(str)) {
				number += 50;
			} else if ("sixty".equalsIgnoreCase(str)) {
				number += 60;
			} else if ("seventy".equalsIgnoreCase(str)) {
				number += 70;
			} else if ("eighty".equalsIgnoreCase(str)) {
				number += 80;
			} else if ("ninety".equalsIgnoreCase(str)) {
				number += 90;
			} else if ("hundred".equalsIgnoreCase(str)) {
				number *= 100;
			} else if ("thousand".equalsIgnoreCase(str)) {
				number *= 1000;
				finalNumber += number;
				number = 0;
			} else if ("million".equalsIgnoreCase(str)) {
				number *= 1000000;
				finalNumber += number;
				number = 0;
			}
		}
		finalNumber += number;
		return finalNumber;
	}
}

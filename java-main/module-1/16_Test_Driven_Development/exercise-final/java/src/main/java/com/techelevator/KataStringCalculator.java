package com.techelevator;

public class KataStringCalculator {

	public int add(String numbersToAdd) {
		int sum = 0;
		if (!numbersToAdd.isEmpty()) {
			String delimiter = ",";
			if (numbersToAdd.startsWith("//")) {
				int terminator = numbersToAdd.indexOf("\n");
				delimiter = numbersToAdd.substring(2, terminator);
				numbersToAdd = numbersToAdd.substring(terminator + 1);
			}
			numbersToAdd = numbersToAdd.replaceAll("\n", delimiter);
			String[] numberStrings = numbersToAdd.split(delimiter);
			for (String number : numberStrings) {
				sum += Integer.parseInt(number);
			}
		}
		return sum;
	}
}

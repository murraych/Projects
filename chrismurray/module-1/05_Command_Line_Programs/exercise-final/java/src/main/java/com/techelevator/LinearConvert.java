package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.print("Please enter the length: ");
		String lengthInput = userInput.nextLine();
		int length = Integer.parseInt(lengthInput);

		System.out.print("Is the measurement in (m)eters, or (f)eet?: ");
		String unitInput = userInput.nextLine();

		if ("f".equals(unitInput)) {
			int meterLength = (int) (length * .3048);
			System.out.println(length + "f is " + meterLength + "m.");
		} else if ("m".equals(unitInput)) {
			int feetLength = (int) (length * 3.2808399);
			System.out.println(length + "m is " + feetLength + "f.");
		} else {
			System.out.println(unitInput + " is an invalid choice.");
		}
	}

}

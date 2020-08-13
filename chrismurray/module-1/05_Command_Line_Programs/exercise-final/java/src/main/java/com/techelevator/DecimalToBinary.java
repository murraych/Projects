package com.techelevator;

public class DecimalToBinary {

	public static void main(String[] args) {

		for (int ix = 0; ix < args.length; ix++) {

			String binary = "";

			int decimal = Integer.parseInt(args[ix]);
			for (; decimal > 0; decimal = decimal / 2) { // the first and last section of the for loop are optional.  Here, we do not do anything before the for loop begins.
				binary = (decimal % 2) + binary;
			}

			System.out.println(args[ix] + " in binary is " + binary);
		}
	}
}

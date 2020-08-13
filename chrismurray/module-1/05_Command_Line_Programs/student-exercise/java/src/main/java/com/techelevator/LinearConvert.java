//Please enter the length: 58
//Is the measurement in (m)eter, or (f)eet? f
//58f is 17m.
//
//f = m * 3.2808399
//
//m = f * 0.3048

package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		double convertedMeasurement = 0;

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the length: ");
		double initialMeasurement = Double.parseDouble(input.nextLine());
		
		System.out.println("Is the measurement in (m)eter, or (f)eet? ");
		String systemChoice = input.nextLine();
		
		if (systemChoice.equals("m")) {
			convertedMeasurement = (initialMeasurement * 3.2808399);
			System.out.println((int)initialMeasurement + "m" + " is " + (int)convertedMeasurement + "f.");
		}
		
		else if (systemChoice.equals("f")) {
			convertedMeasurement = (initialMeasurement * .3048);
			System.out.println((int)initialMeasurement + "f" + " is " + (int)convertedMeasurement + "m."  );
		}
		

		input.close();
	}

}

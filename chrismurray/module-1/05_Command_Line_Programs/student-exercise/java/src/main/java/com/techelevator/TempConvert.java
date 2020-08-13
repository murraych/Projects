package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		double convertedTemp = 0;
		String convertedDegree = "";
		System.out.println("Please enter the temperature: ");
		double initialTempInput = Double.parseDouble(input.nextLine());
		
		System.out.println("Is the temperature in (C)elsius or (F)arenheit? ");
		String degreeChoice = input.nextLine();
		
		if (degreeChoice.equals("F") || degreeChoice.equals("f")) {
			convertedTemp = (initialTempInput - 32) / 1.8;
			degreeChoice = "F";
			convertedDegree = "C.";
		}

		if (degreeChoice.contentEquals("C") || degreeChoice.contentEquals("c")) {
			convertedTemp = (initialTempInput * 1.8 + 32);
			degreeChoice = "C";
			convertedDegree = "F.";
		}
		
		System.out.println((int)initialTempInput + degreeChoice + " is " + (int)convertedTemp + convertedDegree);
		input.close();
	}
}



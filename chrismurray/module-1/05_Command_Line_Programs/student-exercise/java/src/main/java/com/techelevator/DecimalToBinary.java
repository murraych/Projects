//Write a command line program which prompts the user for a series of decimal integer values separated by spaces. Each decimal integer is displayed along with its equivalent 

//Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321
//
//460 in binary is 111001100
//8218 in binary is 10000000011010
//1 in binary is 1
//31313 in binary is 111101001010001
//987654321 in binary is 111010110111100110100010110001


package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter in a series dof decimal values (separated by spaces): ");
		String decimalInput  = input.nextLine();
		String [] decimalStringArray = decimalInput.split(" ");
		int [] decimalIntArray = new int[decimalStringArray.length]; // created an empty integer array, set it to decimal stringarray.length to create appropriate amount of elements.
		
		for (int i = 0; i < decimalIntArray.length; i++) {
			decimalIntArray[i] = Integer.parseInt(decimalStringArray[i]); // taking element from decimalStrinArray turning it into an int and then saving in decimalIntArray.
		}
		for (int i = 0; i < decimalIntArray.length; i++) {
			
			int num = decimalIntArray[i];
			String answer = "";
			while (num > 0) {
				answer = (num % 2) + answer;
				num = num / 2;
			}
		//	System.out.println(decimalIntArray[i] + " equals " + answer);
			System.out.println(decimalIntArray[i] + " equals " + Integer.toBinaryString(decimalIntArray[i]));
		}
		
		input.close();
	}

}

package com.techelevator.BinaryToDecimalConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("*******************************");
		System.out.println("**BINARY TO DECIMAL CONVERTER**");
		System.out.println("*******************************");
		System.out.println();
		System.out.println("Please choose the number associated with your desired conversion below:");
		System.out.println("1) Binary to Decimal");
		System.out.println("2) Decimal to Binary");
		int userChoice = Integer.parseInt(scan.nextLine());

		if (userChoice == 1) {
			System.out.println(binaryToDecimal());
		}
		if (userChoice == 2) {
			System.out.println(decimalToBinary());
		}

	}

	public static String decimalToBinary() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the decimal you would like to convert to binary:");
		int decimal = Integer.parseInt(scan.nextLine());
		String remainder = null;
		String binary = "";
		List<String> binaryList = new ArrayList<String>();
		while (decimal > 0) {
			remainder = Integer.toString(decimal % 2);
			binaryList.add(remainder);
			decimal = decimal / 2;
		}

		for (int i = binaryList.size() - 1; i >= 0; i--) {
			binary += binaryList.get(i);
		}
		return binary;
	}

	public static int binaryToDecimal() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the binary number you would like to convert to decimal:");
		int binary = Integer.parseInt(scan.nextLine());
		List<Integer> digits = new ArrayList<Integer>();
		int sum = 0;
		while (binary > 0) {
			digits.add(binary % 10);
			binary /= 10;
		}
		
		for (int i = 0; i < digits.size(); i++) {
			int power = (int) Math.pow(2, i);
			sum = sum + (digits.get(i) * power); 
		}
		return sum;
		
//		int result = 0;
//		for (int i = 0; i < binary.length(); i++) {
//			int num = Character.digit(binary.charAt(i), 10);
//			int power = (int) Math.pow(2, binary.length() - i);
//			result = result + (num * power);
//		}
//
//		return result;
	}
	
	

}

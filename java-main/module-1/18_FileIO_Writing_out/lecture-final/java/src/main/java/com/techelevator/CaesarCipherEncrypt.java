package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CaesarCipherEncrypt {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);

		System.out.print("Enter the path of a file or directory to encrypt>>> ");
		String inPath = userInput.nextLine();
		File inFile = new File(inPath);
		Scanner inputFile = new Scanner (inFile);

		System.out.print("Enter offset>>>");
		int offset = Integer.parseInt(userInput.nextLine());
		
		System.out.print("Enter file to write to>>>");
		String outPath = userInput.nextLine();
		File outFile = new File(outPath);
		PrintWriter outputFile = new PrintWriter(outFile);
		while (inputFile.hasNext()) {
			String originalText = inputFile.nextLine();
			String cipher = encrypt(originalText, offset).toString();
			outputFile.println(cipher);
		}
		outputFile.flush();
		outputFile.close();
	}


	// Encrypts text using shift
	public static StringBuffer encrypt(String text, int shift) {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < text.length(); i++) {
			if (Character.isSpaceChar(text.charAt(i))) {
				result.append(" ");
			}
			else if (Character.isUpperCase(text.charAt(i))) {
				char ch = (char) (((int) text.charAt(i) + shift - 65) % 26 + 65);
				result.append(ch);
			} else {
				char ch = (char) (((int) text.charAt(i) + shift - 97) % 26 + 97);
				result.append(ch);
			}
		}
		return result;
	}

}

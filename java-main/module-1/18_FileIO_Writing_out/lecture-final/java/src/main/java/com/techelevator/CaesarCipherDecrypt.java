package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CaesarCipherDecrypt {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);

		System.out.print("Enter the path of a file or directory to decrypt>>> ");
		String inPath = userInput.nextLine();
		File inFile = new File(inPath);
		Scanner inputFile = new Scanner(inFile);

		System.out.print("Enter offset>>>");
		int offset = Integer.parseInt(userInput.nextLine());

		System.out.print("Enter file to write to>>>");
		String outPath = userInput.nextLine();
		File outFile = new File(outPath);
		try (PrintWriter outputFile = new PrintWriter(outFile)) {
			while (inputFile.hasNext()) {
				String originalText = inputFile.nextLine();
				String cipher = decrypt(originalText, offset).toString();
				outputFile.println(cipher);
			}
		}

	}

	// Decrypts cipher using shift
	public static StringBuffer decrypt(String cipher, int shift) {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < cipher.length(); i++) {
			if (cipher.charAt(i) == ' ') {
				result.append(' ');
			} 
			else if (Character.isUpperCase(cipher.charAt(i))) {
				char ch = (char) (((int) cipher.charAt(i) + shift - 65) % 26 + 65);
				result.append(ch);
			} else {
				char ch = (char) (((int) cipher.charAt(i) + shift - 97) % 26 + 97);
				result.append(ch);
			}
		}
		return result;
	}

}

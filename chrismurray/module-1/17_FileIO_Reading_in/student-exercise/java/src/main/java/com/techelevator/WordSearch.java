package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
	
		Scanner userInput = new Scanner(System.in); // calling the constructor on the scanner class. ties scanner object to the input
		System.out.println("Enter the file: "); 
		String fileName = userInput.nextLine(); //pick up the user input storing into fileName
		
		File file = new File(fileName); // class File now has an object in this class called file. gives you metadata. gives you information about the file. cannot edit
		// connect my program to the file itself with a Stream (Scanner)
		Scanner fileInput = new Scanner(file);// THis line connects program to the file itself. Scanner class will let you pass file object to the scanner class. anything we want to do now we use fileInput. other variables were only to get to fileInput
		
		System.out.println("What is the word you are searching for? ");
		String word = userInput.nextLine();
		
		System.out.println("Should the search be case-sensitive (Y/N)?");
		String answer = userInput.nextLine(); // if anser is N, we need to ignore the case
		
		//need counter for the line number
		int count = 1;
		while  (fileInput.hasNextLine()) { //keep reading until we hit the end of the file. hasNextLine() returns a boolean
			String line = fileInput.nextLine(); //picks up 1 line and stores it in the var line
			// fileInput.next();          
			
			if (answer.equals("N")) {
				if (line.toUpperCase().contains(word.toUpperCase())) {
					System.out.println(count + ") " + line);
			}
		} else if (line.contains(word)) {
				System.out.println(count + ") " + line);
			}
			count ++;
		}
		fileInput.close();
		userInput.close();

	}

}

package com.techelevator.moduleOneReview;

public class Dog { //  template file or definition file
					// gives characteristics and behavior of a Dog
	
	
	// Data members -- start with access modifier
	// attributes. 
	// not methods
	private int humanYears;
	private String breed;
	private String furColor = "Brown";
	private boolean isSleeping;
	
	
	
	
	// getter and setter methods
	
	// method to get derived property
	public int getDogYears() {
		return (humanYears * 7);//dont have to have this. here because there is no local var humanYears in the method.
	}
	
	public int getHumanYears() {
		return humanYears;
	}
	public void setHumanYears(int humanYears) {
		this.humanYears = humanYears;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getFurColor() {
		return furColor;
	}
	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}
	public boolean isSleeping() {
		return isSleeping;
	}
	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}
	
	public Dog(int humanYears, String breed) {
		this.humanYears = humanYears;
		this.breed = breed;
	}
	
	public Dog() {
	}
	}


//	
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
//public class FindAndReplace {
//
//	public static void main(String[] args) {
//
//		Scanner userInput = new Scanner(System.in);
//		System.out.println("What is the word you are searching for? ");
//		String searchWord = userInput.nextLine();
//
//		System.out.println("What do you want to replace the word with?");
//		String replaceWord = userInput.nextLine();
//
//		try {
//			System.out.println("Enter the file: ");
//			String fileName = userInput.nextLine();
//
//			File file = new File(fileName);
//			Scanner fileInput = new Scanner(file);
//
//			System.out.println("Please enter the destination file");
//			String destination = userInput.nextLine();
//
//			File destinationFile = new File(destination);
//			PrintWriter myWriter = new PrintWriter(destinationFile);
//
//			while (fileInput.hasNextLine()) {
//				String line = fileInput.nextLine();
//
//				if (line.contains(searchWord)) {
//					line = line.replaceAll(searchWord, replaceWord);
//				}
//				myWriter.println(line);
//			}
//			myWriter.flush();
//			myWriter.close();
//			fileInput.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("That file does not exist.");
//			System.exit(1);
//		}
//
//		userInput.close();
//
//	}
//
//}
	



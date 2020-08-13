package com.techelevator.practical_example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class practicalApplications {

	public practicalApplications() {
		// Created in lecture as per **CHET SULLIVAN'S** 30 minute challenge at Jeff's suggestion to write a practical
		//  example of a logging routine in real time with the class
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		try (Logger log = new Logger("c:\\data\\log.txt");){
		
			System.out.println("Doing task 1");
			log.Write("Opening Log Session");
			
			try(Scanner userInput = new Scanner(System.in);){
			
				for(int x = 0; x<5; x++)
				{
					System.out.print("Please enter something [" + x + "] >: ");
				
					log.Write(LocalDate.now() + " " + LocalTime.now() + ": User entered: " + userInput.nextLine());
				}
			}

			log.Write("Closing Log Session");
		} 
		catch (IOException ex) {
			System.out.println("IO Exception at:" + ex.getMessage());
		} 
		catch (Exception ex) {
			System.out.println("General Exception at:" + ex.getMessage());
		}
		
			System.out.println("That was fun");
		
	}

}

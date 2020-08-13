package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws FileNotFoundException {
	
		List<Car> carList = new ArrayList<>();
		
		Car myCar = new Car (2018, "Ford", false);
		
		File inputFile = new File("data-files/CarInput.csv");
		Scanner fileScanner = new Scanner(inputFile);
		
		while (fileScanner.hasNextLine()) {
			
			String[] lineInput = fileScanner.nextLine().split("\\,");
			carList.add(new Car(Integer.parseInt(lineInput[0]), lineInput[1], Boolean.parseBoolean(lineInput[2])));	
		}
		
		int sum = 0;
//		for (Car car : carList) {
		for (int i = 0; i  < carList.size(); i++) {
			sum += carList.get(i).getAge();
			System.out.println(carList.get(i));
		}
		System.out.println(sum);
	}

}

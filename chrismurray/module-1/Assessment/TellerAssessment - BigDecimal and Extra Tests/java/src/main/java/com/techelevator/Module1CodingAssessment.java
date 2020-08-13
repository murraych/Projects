package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(3500.00), BigDecimal.valueOf(2350.00));
		
		System.out.println("Object:");
		System.out.println("Manufacturer: " + tellerMachine.getManufacturer());
		System.out.println("\t Deposits: " + tellerMachine.getDeposits());
		System.out.println("\t Withdrawals: " + tellerMachine.getWithdrawals());
		System.out.println("\t Balance: " + tellerMachine.getBalance());
		
		
		File file  = new File ("data-files/TellerInput.csv");
		List<TellerMachine> tellerList = new ArrayList<>();
		
		
		try {
			Scanner inputFile = new Scanner(file);
			
			while(inputFile.hasNext()) {
				String[] line = inputFile.nextLine().split(",");
				TellerMachine temp = new TellerMachine(line[0], new BigDecimal(line[1]), new BigDecimal(line[2]));
				tellerList.add(temp);			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n");
		BigDecimal total = new BigDecimal(0);
		for (TellerMachine tellerObj: tellerList) {
			System.out.println(tellerObj);
			total = total.add(tellerObj.getBalance());
		}
		
		System.out.println("Total balance:                    $" + total);
		

	}

}

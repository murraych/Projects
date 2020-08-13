package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws FileNotFoundException {

		TellerMachine tellerMachine = new TellerMachine("My Bank", 3500.00, 500.00);

		System.out.println("My Teller Machine Object");
		System.out.println("\t Name: " + tellerMachine.getManufacturer());
		System.out.println("\t Deposit: " + tellerMachine.getDeposits());
		System.out.println("\t Withdrawals: " + tellerMachine.getWithdrawals());
		System.out.println("\t Balance: " + tellerMachine.getBalance());

		System.out.println(tellerMachine.toString());

		File file = new File("data-files/TellerInput.csv");
		Scanner inputScanner = new Scanner(file);
		
		List <TellerMachine> tellerList = new ArrayList<>();		
		while (inputScanner.hasNext()) {
			String[] line = inputScanner.nextLine().split(",");
			TellerMachine temp = new TellerMachine(line[0], Double.parseDouble(line[1]), 
					Double.parseDouble(line[2]));
			tellerList.add(temp);		
		}
		
		// loop through and add up all the balances
		double total = 0;
		for (TellerMachine teller:  tellerList) {
			System.out.println(teller);
			total += teller.getBalance();
		}
		
		System.out.println("Balance: " + total);
	}

}

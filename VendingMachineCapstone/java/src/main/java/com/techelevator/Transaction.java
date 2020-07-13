package com.techelevator;

public class Transaction {

	//Data Members
	private double balance = 0;

	
	//Constructors
	
	//Getters and Setters
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	//Methods
	
	public double feedMoney(double depositAmount) {
		
		return this.balance = balance + depositAmount;

	}
	
	public boolean isMoneyWholeDollarAmount(int depositAmount) {
		
		if (depositAmount == 1 || depositAmount == 2 || depositAmount == 5 || depositAmount == 10) {
			return true;
		}
		else return false;
	}
	
	public double purchaseTransaction(double costOfItem) {
		
		return this.balance = balance - costOfItem;
		
	}
	
	public void makeChange(double balance) {
		
		int amount, quarters, dimes, nickels, pennies;
			
		
		amount = (int)(balance*100); //97
		quarters = amount / 25;
		amount = amount % 25;
		dimes = amount / 10;
		amount = amount % 10;
		nickels = amount / 5;
		amount = amount %5;
		pennies = amount;
		balance = 0;
		
		System.out.println("\nYour change is:\nQuarters: " + quarters + "\nDimes: " + dimes + 
				"\nNickels: " + nickels + "\nPennies: " + pennies + "\nThe current balance is: $" + String.format("%.2f", balance));
		
	}
	
	


	
	
	
}

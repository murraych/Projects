package com.techelevator;

public class BankAccount {

//Attributes
	private String accountHolderName;
	private String accountNumber;
	private int balance;
	
	
//Getters and Setters
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	
//Constructors
	public BankAccount (String accountHolderName, String accountNumber) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
	}
	
	public BankAccount (String accountHolderName, String accountNumber, int balance) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
//Methods
	public int deposit(int amountToDeposit) {
		return balance += amountToDeposit;
	}
	
	public int withdraw(int amountToWithdraw) {
		return balance -= amountToWithdraw;
	}
	
	
	
	
	
	
}

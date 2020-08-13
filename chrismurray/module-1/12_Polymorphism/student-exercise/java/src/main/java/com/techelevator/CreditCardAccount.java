package com.techelevator;

public class CreditCardAccount implements Accountable {

//Variables
	private String accountHolder;
	private String accountNumber;
	private int debt;
	private int balance;

//Constructor
	public CreditCardAccount(String accountHolder, String accountNumber) {
		debt = 0;
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
	}

//Getters and Setters
	public String getAccountHolder() {
		return accountHolder;
	}

	public String getAccountNumber() {
		return accountNumber;
	}


	public int getDebt() {
		return debt;
	}
	
	@Override
	public int getBalance() {
		balance = debt *(-1);
		return balance;
	}
	

//Methods

	public int pay(int amountToPay) {
		debt -= amountToPay;
		return debt;
	}

	public int charge(int amountToCharge) {
		debt += amountToCharge;
		return debt;
	}
	
	

}

package com.techelevator;

public class TellerMachine {

	
	private String manufacturer;
	private double deposits;
	private double withdrawals;
	private double balance;
	
	public TellerMachine(String manufacturer, double deposits, double withdrawals) {
		
		this.manufacturer = manufacturer;
		this.deposits = deposits;
		this.withdrawals = withdrawals;
		this.balance = this.deposits - this.withdrawals; // set the derived member balance
		
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getDeposits() {
		return deposits;
	}

	public void setDeposits(double deposits) {
		this.deposits = deposits;
	}

	public double getWithdrawals() {
		return withdrawals;
	}

	public void setWithdrawals(double withdrawals) {
		this.withdrawals = withdrawals;
	}

	public double getBalance() {
		return balance;
	}
	
	
	public boolean isValidCardNumber(String cardNumber) {
		if (cardNumber.startsWith("5") && cardNumber.length() == 16) {
			return true;
		}
		
		else if (cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16)) {
			return true;
		}
		
		else if (cardNumber.startsWith("3") && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7')) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override // -- overriding version in Object class
	public String toString() {
		return "ATM - " + manufacturer + " - " + balance;
	}

}

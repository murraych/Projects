package com.techelevator;

import java.math.BigDecimal;

public class TellerMachine {

	private String manufacturer;
	private BigDecimal deposits;
	private BigDecimal withdrawals;
	
	public TellerMachine(String manufacturer, BigDecimal deposits, BigDecimal withdrawals) {
		this.manufacturer = manufacturer;
		this.deposits = deposits;
		this.withdrawals = withdrawals;
		calculateBalance();
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public BigDecimal getDeposits() {
		return deposits;
	}

	public void setDeposits(BigDecimal deposits) {
		this.deposits = deposits;
	}

	public BigDecimal getWithdrawals() {
		return withdrawals;
	}

	public void setWithdrawals(BigDecimal withdrawals) {
		this.withdrawals = withdrawals;
	}

	
	public BigDecimal getBalance() {
		return calculateBalance();
	}
	private BigDecimal calculateBalance() {
		BigDecimal balance = deposits.subtract(withdrawals);
		return balance;
	}
	
	public boolean checkCardNumber(String cardNumber) {
		if (cardNumber.startsWith("5") && cardNumber.length() == 16) {
			return true;
		} else if (cardNumber.startsWith("4") && (cardNumber.length()  == 13 || cardNumber.length() == 16)) {
			return true;
		} else if (cardNumber.charAt(0) == '3' && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7')) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
//		return "ATM - " + manufacturer + " " + getBalance();
		return String.format("ATM - %-27s $%7.2f", manufacturer, getBalance());
	}

}

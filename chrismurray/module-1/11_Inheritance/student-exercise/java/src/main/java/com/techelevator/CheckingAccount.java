package com.techelevator;

public class CheckingAccount extends BankAccount{

//CHILD CLASS CONSTRUCTOR
	public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
		}
	
	public CheckingAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
	}

//METHODS
	
	@Override
	public int withdraw(int amountToWithdraw) {
		int balanceAfterWithdraw = super.getBalance() - amountToWithdraw;
		
		if(balanceAfterWithdraw <= -100) {
			return super.getBalance();
		}
			
		if(balanceAfterWithdraw < 0) {
			return super.withdraw(amountToWithdraw + 10);
		}
		
		else { 
			return super.withdraw(amountToWithdraw);
			}
		}
}

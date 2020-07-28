package com.techelevator.tenmo.models;

import java.math.BigDecimal;

public class Account {

//Data Members
	private int accountId;
	private int userId;
	private BigDecimal balance;
	
	
//CTOR
		public Account() {
		}

//Methods
		
		public void increaseBalance() {
			//TODO increase balance after transfer
		}
		
		public void decreaseBalance() {
			//TODO decrease balance after transfer
		}
		
//Getters and Setters

		public int getAccountId() {
			return accountId;
		}


		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public BigDecimal getBalance() {
			return balance;
		}


		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}
	
		@Override
		public String toString() {
			return "\n--------------------------------------------" +
	                "\n Account Details" +
	                "\n--------------------------------------------" +
	                "\n Account ID: " + accountId +
	                "\n User ID: " + userId +
	                "\n Balance: " + balance;
	              
		}
		
		
}

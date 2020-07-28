package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Account {

//Data Members
	private long accountId;
	private long userId;
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

		public long getAccountId() {
			return accountId;
		}


		public void setAccountId(long accountId) {
			this.accountId = accountId;
		}


		public long getUserId() {
			return userId;
		}


		public void setUserId(long userId) {
			this.userId = userId;
		}


		public BigDecimal getBalance() {
			return balance;
		}


		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}
	
		
		
		
}

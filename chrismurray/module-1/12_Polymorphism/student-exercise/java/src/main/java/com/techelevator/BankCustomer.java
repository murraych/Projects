package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable {

	
	private String name;
	private String address;
	private String phoneNumber;
	private List<Accountable> accounts = new ArrayList<>();
		
	@Override public int getBalance() {
		return 0;
	}

	public void addAccount(Accountable newAccount) {
		accounts.add(newAccount); //adds the new account object to the list holding all the accounts for the bank customer
	}
	
	public boolean isVip() {
		int sum = 0;
		for(Accountable account: accounts) {
		sum += account.getBalance();
		}
		
		if (sum >= 25000) {
			return true;
		} else {
			return false;
		}
			
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Accountable[] getAccounts() {
		Accountable[] accountsArray = new Accountable[accounts.size()];
		accountsArray = accounts.toArray(accountsArray);
		
		return accountsArray;
		}


	public void setAccounts(List<Accountable> accounts) {
		this.accounts = accounts;
	}
	
	

}

package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

import com.techelevator.tenmo.model.Account;

public interface AccountDAO {
	
	Account getBalance(String user);
	
	void addToBalance(BigDecimal amount, int userId);
	
	void subtractFromBalance(BigDecimal amount, int userId);
	

}

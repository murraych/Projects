package com.techelevator.tenmo.models;

import java.math.BigDecimal;

public class Transfer {

	
//Data Members
	
	private int transferId;
	private int transferTypeId;
	private int transferStatusId;
	private int accountFrom;
	private int accountTo;
	private BigDecimal amount;
	
//Constructors
	
	public Transfer() {
	
	}
	
	public Transfer(int accountTo, BigDecimal amount) {
		this.accountTo = accountTo;
		this.amount = amount;
	}
	
//Methods
	
	
//Getters and Setters
	
	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public int getTransferTypeId() {
		return transferTypeId;
	}

	public void setTransferTypeId(int transferTypeId) {
		this.transferTypeId = transferTypeId;
	}

	public int getTransferStatusId() {
		return transferStatusId;
	}

	public void setTransferStatusId(int transferStatusId) {
		this.transferStatusId = transferStatusId;
	}

	public int getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(int accountFrom) {
		this.accountFrom = accountFrom;
	}

	public int getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(int accountTo) {
		this.accountTo = accountTo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	@Override
	public  String toString() {
		
		return "Id: "+ this.transferId 
				+ "\n transferTypeId " + transferTypeId
				+ "\n transferStatusId: " + transferStatusId
				+ "\n accountFrom: " + accountFrom
				+ "\n accountTo: " + accountTo
				+ "\n amount: " + amount;
				
				
				
	
		
	}

	
		
		
}

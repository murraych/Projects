package com.techelevator.tenmo.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Transfer {

	
//Data Members
	
	private int transferId;
//	@Min (value=1, message = "The field transfer type is invalid.")
//	@Max (value = 2, message = "The field transfer type is invalid")
	private int transferTypeId;
//	@Min (value=1, message = "The field transfer status is invalid.")
//	@Max (value = 3, message = "The field transfer type is invalid.")
	private int transferStatusId;
//	@Min (value=1, message = "Account From Id required.")
	private int accountFrom;
//	@Min (value=1, message = "Account To Id required.")
	private int accountTo;
	//@DecimalMin (value="0.01", message = "Please enter a valid amount to transfer.")
	private BigDecimal amount;
	
//Constructors
	
	public Transfer() {
	
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
		
		return "transfer id: "+ this.transferId 
				+ "\n transferTypeId " + transferTypeId
				+ "\n transferStatusId: " + transferStatusId
				+ "\n accountFrom: " + accountFrom
				+ "\n accountTo: " + accountTo
				+ "\n amount: " + amount;
				
				
				
	
		
	}

		

}

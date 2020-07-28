package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

public interface TransferDAO {
	
	Transfer getTransferById(int id);
	
	List<Transfer> getAllTransfers(User user);
	
	Transfer sendMoney(Transfer transfer, User userSending);
	
	

}

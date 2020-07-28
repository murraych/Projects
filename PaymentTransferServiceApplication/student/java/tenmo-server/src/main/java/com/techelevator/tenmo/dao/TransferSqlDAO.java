package com.techelevator.tenmo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.InvalidTransferException;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

@Component
public class TransferSqlDAO implements TransferDAO {
	
	private JdbcTemplate jdbcTemplate;
	private AccountSqlDAO accountDAO;

	public TransferSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
		this.accountDAO = new AccountSqlDAO(this.jdbcTemplate);
	}

	@Override
	public Transfer getTransferById(int id) {
		Transfer transfer = null;
		 
        String sql = "select * from transfers WHERE  transfer_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            transfer = mapRowToTransfer(results);
           
        }

        return transfer;
	}

	@Override
	public List<Transfer> getAllTransfers(User user) {
		
		 List<Transfer> transfers = new ArrayList<>();
		 
	        String sql = "select * from transfers WHERE account_from = ? OR account_to = ?";

	        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user.getId(), user.getId());
	        while(results.next()) {
	            Transfer transfer = mapRowToTransfer(results);
	            transfers.add(transfer);
	        }

	        return transfers;
		
	}

//	@Override
//	public Transfer sendMoney(Transfer transferRequest, String userSending) {
//		
//		Transfer transfer = createTransfer(transferRequest, userSending);
//		
//		return transfer;
//	}
	
	
	


	@Override
	public Transfer sendMoney(Transfer transferFromClient, User userSending) {
		
		
		
		BigDecimal balance = accountDAO.getBalance(userSending.getUsername()).getBalance();
		
		BigDecimal minThreshold = new BigDecimal ("0.00");
		
		try {
			if(balance.compareTo(transferFromClient.getAmount()) == -1) {
				throw new InvalidTransferException();
				
			}
			
			if(transferFromClient.getAccountTo() == userSending.getId()) {
				throw new InvalidTransferException();
				
			}
			
			if(transferFromClient.getAmount().compareTo(minThreshold) == -1 || transferFromClient.getAmount().compareTo(minThreshold) == 0) {
				throw new InvalidTransferException();
			}
			
		} catch (InvalidTransferException e) {
			
			return transferFromClient;
		}
		
		Transfer transfer = createTransfer(transferFromClient, userSending);
		String sql = "INSERT INTO transfers (transfer_type_id, transfer_status_id, account_from, account_to, amount)"
				+ "values (? ,? ,? , ?, ?) RETURNING transfer_id";
		
		int id = jdbcTemplate.queryForObject(sql, int.class, transfer.getTransferTypeId(), transfer.getTransferStatusId(), transfer.getAccountFrom(),transfer.getAccountTo(),transfer.getAmount());
		
		transfer.setTransferId(id);
		
		
		accountDAO.addToBalance(transfer.getAmount(), transfer.getAccountTo());
		accountDAO.subtractFromBalance(transfer.getAmount(), transfer.getAccountFrom());
		return transfer;
	}
	
	
	private Transfer createTransfer(Transfer transferFromClient, User userSending) {
		
		
		Transfer transfer = new Transfer();
		transfer.setAccountFrom(userSending.getId().intValue());
		transfer.setAccountTo(transferFromClient.getAccountTo());
		transfer.setAmount(transferFromClient.getAmount());
		transfer.setTransferStatusId(2);
		transfer.setTransferTypeId(2);
		
		return transfer;
		
	}
	
	private Transfer mapRowToTransfer(SqlRowSet results) {
		
		Transfer transfer = new Transfer();
		
		transfer.setTransferId(results.getInt("transfer_id"));
		transfer.setTransferTypeId(results.getInt("transfer_type_id"));
		transfer.setTransferStatusId(results.getInt("transfer_status_id"));
		transfer.setAccountFrom(results.getInt("account_from"));
		transfer.setAccountTo(results.getInt("account_to"));
		transfer.setAmount(results.getBigDecimal("amount"));
		
		return transfer;
		
		
	}
	
	
	

}

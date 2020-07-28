package com.techelevator.tenmo.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.TransferDAO;
import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

@PreAuthorize("isAuthenticated()")
@RestController
public class UserController {
	
	private UserDAO userDAO;
	private AccountDAO accountDAO;
	private TransferDAO transferDAO;
	
	

	public UserController(UserDAO userDAO, AccountDAO accountDAO, TransferDAO transferDAO) {
		this.userDAO = userDAO;
		this.accountDAO = accountDAO;
		this.transferDAO = transferDAO;
	}
	
	
	//for the list users command
	@RequestMapping(path="/user", method = RequestMethod.GET)
	public List<User> listAll(){
		return userDAO.findAll();
	}
	
	@RequestMapping(path="/user/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable int id){
		return userDAO.getUserById(id);
	}
	
	
	//
	@RequestMapping(path="/user/balance", method = RequestMethod.GET)
	public Account getBalance(Principal principal) {
	
		return accountDAO.getBalance(principal.getName());
	}
	
	@RequestMapping(path="/user/transfers", method = RequestMethod.GET)
	public List <Transfer> listAllUserTransfer(Principal principal){
		User user = userDAO.findByUsername(principal.getName());
		
		return transferDAO.getAllTransfers(user);
	}
	
	@RequestMapping(path="/user/transfers/{id}", method = RequestMethod.GET)
	public Transfer getTransferById(@PathVariable("id") int transferId, Principal principal) {
		
		
		
		return transferDAO.getTransferById(transferId);
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/user/transfers", method = RequestMethod.POST)
	public Transfer makeTransfer(@Valid @RequestBody Transfer transferFromUser, Principal principal) {
		User user = userDAO.findByUsername(principal.getName());
		//expecting account to, amount
		
		
		
		System.out.println("Transfer from client: " + transferFromUser.toString());
		Transfer transfer = transferDAO.sendMoney(transferFromUser, user);
		

		System.out.println(transfer.toString());
		return transfer;
		
	}
	
	

}

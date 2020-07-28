package com.techelevator.tenmo.services;

import java.math.BigDecimal;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.User;
import com.techelevator.view.ConsoleService;

public class UserService {
	
	
public static String AUTH_TOKEN = "";
private final String BASE_URL;
private final RestTemplate restTemplate = new RestTemplate();
private final ConsoleService console = new ConsoleService(System.in, System.out);


	public UserService(String url) {
		BASE_URL = url;
	}

	public Account showAccountBalanceByAccountId() throws UserServiceException {
		//shows the user his account balance
		//send in this.user idea, return specific balance, get method
		//user.getUsername()
		Account account = null;
		try {
			account = restTemplate.exchange(BASE_URL + "user/balance/", HttpMethod.GET, 
					makeAuthEntity(), Account.class).getBody();
			} catch (RestClientResponseException e) {
				throw new UserServiceException(e.getRawStatusCode() + " : " + e.getResponseBodyAsString());
			}
		
		return account;
	}
	 
	public Transfer[] listTransfers() throws UserServiceException {
		// show list of transfers user logged in user has sent or received
		//send in user, return list, get method
		Transfer[] transfers = null;
		try {
			transfers = restTemplate.exchange(BASE_URL + "user/transfers", HttpMethod.GET, makeAuthEntity(),
				Transfer[].class).getBody();
		} catch (RestClientResponseException e) {
			throw new UserServiceException(e.getRawStatusCode() + " : " + e.getResponseBodyAsString());
		}
		
		
		return transfers;
	}
	
	public Transfer sendTransfer(int receiveUser, BigDecimal transferAmount) throws UserServiceException {
		// send transfer of a specific amount of TE bucks to a registered user
		//send in recieveUser, amount (Transfer object?) - POST method for transferrings, 
		//PUT/backend update on on account balance
		Transfer transfer = new Transfer(receiveUser, transferAmount);
		try {
			transfer = restTemplate.postForObject(BASE_URL + "user/transfers", 
					makeTransferEntity(transfer), Transfer.class);
			//if server detects an error with the transfer, it will return a transfer Id of 0 and make no updates
			if (transfer.getTransferId() == 0) {
				System.out.println("Invalid transfer.");
			}
		} catch (RestClientResponseException e) {
			throw new UserServiceException(e.getRawStatusCode() + " : " + e.getResponseBodyAsString());
		}
		
		return transfer;
	}
	
	public Transfer getTransferByID(int transferId) throws UserServiceException {
		// retrieve details of transfer by a specific transfer ID
		Transfer transfer = null;
		try {
			transfer = restTemplate.exchange(BASE_URL + "user/transfers/" + transferId, HttpMethod.GET, makeAuthEntity(), 
					Transfer.class).getBody();
		} catch (RestClientResponseException e) {
			throw new UserServiceException(e.getRawStatusCode() + " : " + e.getResponseBodyAsString());
		}
		return transfer;
	}
	
	public User[] listUsers() throws UserServiceException {
		User[] users = null;
		try {
			users = restTemplate.exchange(BASE_URL + "user", HttpMethod.GET, makeAuthEntity(), User[].class).getBody();
		} catch (RestClientResponseException e) {
			throw new UserServiceException(e.getRawStatusCode() + " : " + e.getResponseBodyAsString());
		}
		return users;
	}
	
	public User getUserById(int id) throws UserServiceException{
		User user = null;
		try {
			user = restTemplate.exchange(BASE_URL + "user/" + id, HttpMethod.GET, makeAuthEntity(), User.class).getBody();
		} catch (RestClientResponseException e) {
			throw new UserServiceException(e.getRawStatusCode() + " : " + e.getResponseBodyAsString());
		}
		return user;
	}
	
	private HttpEntity<Transfer> makeTransferEntity(Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(AUTH_TOKEN);
        HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);
        return entity;
    }
		
	  private HttpEntity makeAuthEntity() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setBearerAuth(AUTH_TOKEN);
	    HttpEntity entity = new HttpEntity<>(headers);
	    return entity;
	  }
	
}

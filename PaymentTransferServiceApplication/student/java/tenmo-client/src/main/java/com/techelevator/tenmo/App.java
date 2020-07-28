package com.techelevator.tenmo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.web.client.RestClientResponseException;

import com.techelevator.tenmo.models.AuthenticatedUser;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.User;
import com.techelevator.tenmo.models.UserCredentials;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.AuthenticationServiceException;
import com.techelevator.tenmo.services.UserService;
import com.techelevator.tenmo.services.UserServiceException;
import com.techelevator.view.ConsoleService;

public class App {

private static final String API_BASE_URL = "http://localhost:8080/";
    
    private static final String MENU_OPTION_EXIT = "Exit";
    private static final String LOGIN_MENU_OPTION_REGISTER = "Register";
	private static final String LOGIN_MENU_OPTION_LOGIN = "Login";
	private static final String[] LOGIN_MENU_OPTIONS = { LOGIN_MENU_OPTION_REGISTER, LOGIN_MENU_OPTION_LOGIN, MENU_OPTION_EXIT };
	private static final String MAIN_MENU_OPTION_VIEW_BALANCE = "View your current balance";
	private static final String MAIN_MENU_OPTION_SEND_BUCKS = "Send TE bucks";
	private static final String MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS = "View your past transfers";
	private static final String MAIN_MENU_OPTION_REQUEST_BUCKS = "Request TE bucks";
	private static final String MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS = "View your pending requests";
	private static final String MAIN_MENU_OPTION_LOGIN = "Login as different user";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_VIEW_BALANCE, MAIN_MENU_OPTION_SEND_BUCKS, MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS, MAIN_MENU_OPTION_REQUEST_BUCKS, MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS, MAIN_MENU_OPTION_LOGIN, MENU_OPTION_EXIT };
	
    private AuthenticatedUser currentUser;
    private ConsoleService console;
    private AuthenticationService authenticationService;
    private UserService userService;

    public static void main(String[] args) {
    	App app = new App(new ConsoleService(System.in, System.out), new AuthenticationService(API_BASE_URL), new UserService(API_BASE_URL));
    	app.run();
    }

    public App(ConsoleService console, AuthenticationService authenticationService, UserService userService) {
		this.console = console;
		this.authenticationService = authenticationService;
		this.userService = userService;
	}

	public void run() {
		System.out.println("*********************");
		System.out.println("* Welcome to TEnmo! *");
		System.out.println("*********************");
		
		registerAndLogin();
		try {
			mainMenu();
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void mainMenu() throws UserServiceException {
		while(true) {
			String choice = (String)console.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(MAIN_MENU_OPTION_VIEW_BALANCE.equals(choice)) {
				viewCurrentBalance();
			} else if(MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS.equals(choice)) {
				viewTransferHistory();
			} else if(MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS.equals(choice)) {
				viewPendingRequests();
			} else if(MAIN_MENU_OPTION_SEND_BUCKS.equals(choice)) {
				sendBucks();
			} else if(MAIN_MENU_OPTION_REQUEST_BUCKS.equals(choice)) {
				requestBucks();
			} else if(MAIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else {
				// the only other option on the main menu is to exit
				exitProgram();
			}
		}
	}

	private void viewCurrentBalance() {
//		while(isAuthenticated()) {
//			String choice = (String)console.getChoiceFromOptions(MAIN_MENU_OPTION)
		try {
			BigDecimal balance = userService.showAccountBalanceByAccountId().getBalance();
			System.out.println("Your current account balance is: $" + balance);
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		}
		
	}

	private void viewTransferHistory() throws UserServiceException {
		
		Set<Integer> transferIds = new HashSet<>();
		Transfer transfer = null;
		
		try {
			 Transfer[] transfers = userService.listTransfers();
			 printTransfers(transfers);
			 transferIds = populateTransferIdSet(transfers);
			 
			 
		} catch (RestClientResponseException e) {
			throw new UserServiceException(e.getRawStatusCode() + " : " + e.getResponseBodyAsString());
		}
		
		
		Object choice = null;
		
		while(choice == null) {
			String input = console.getUserInput("\n Please enter a transfer you would like(0 to cancel)");
			try {
				int selectedOption = Integer.valueOf(input); 
				if (selectedOption == 0) {
					System.out.println("Transfer detail cancelled - returning to main menu.");
					run();
					return;
				}
				if (transferIds.contains(selectedOption)  ) {
					choice = selectedOption;
					transfer  = userService.getTransferByID((int)choice);
					
					printSingleTransferDetails(transfer);
				
				}

			} catch (NumberFormatException e) {

			}
			
			if (choice == null) {
				System.out.println(input + " is not a valid option.");

			}
		}
	}

	private void viewPendingRequests() {
		// TODO Auto-generated method stub
		
	}

	private void sendBucks() throws UserServiceException {
		printUsersHeading();
		int id = -1;
		BigDecimal amount = new BigDecimal("0.00");
		User[] users = userService.listUsers();
		Map<Integer, String> userMap = new HashMap<>();
		for (int i = 0; i < users.length; i++) {
			System.out.printf("\n%-15d%-30s", users[i].getId(), users[i].getUsername());
			userMap.put(users[i].getId(), users[i].getUsername());
		}
		try {
			id = Integer.parseInt(console.getUserInput("\nPlease Enter ID of the user you are sending to (0 to cancel)"));
			if (id == 0) {
				return;
			}
			if (userMap.containsKey(id)) {
				try {
					amount = new BigDecimal(console.getUserInput("Enter Amount"));
					userService.sendTransfer(id, amount);
				} catch(NumberFormatException e) {
					System.out.println("Error, please enter a valid amount");
				}
			} else System.out.println("Invalid User.");
			
		} catch(NumberFormatException e) {
			System.out.println("Error, invalid input.");
		} 
		
	}

	private void requestBucks() {
		// TODO Auto-generated method stub
		
	}
	
	private void exitProgram() {
		System.exit(0);
	}

	private void registerAndLogin() {
		while(!isAuthenticated()) {
			String choice = (String)console.getChoiceFromOptions(LOGIN_MENU_OPTIONS);
			if (LOGIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else if (LOGIN_MENU_OPTION_REGISTER.equals(choice)) {
				register();
			} else {
				// the only other option on the login menu is to exit
				exitProgram();
			}
		}
	}

	private boolean isAuthenticated() {
		return currentUser != null;
	}

	private void register() {
		System.out.println("Please register a new user account");
		boolean isRegistered = false;
        while (!isRegistered) //will keep looping until user is registered
        {
            UserCredentials credentials = collectUserCredentials();
            try {
            	authenticationService.register(credentials);
            	isRegistered = true;
            	System.out.println("Registration successful. You can now login.");
            } catch(AuthenticationServiceException e) {
            	System.out.println("REGISTRATION ERROR: "+e.getMessage());
				System.out.println("Please attempt to register again.");
            }
        }
	}

	private void login() {
		System.out.println("Please log in");
		currentUser = null;
		while (currentUser == null) //will keep looping until user is logged in
		{
			UserCredentials credentials = collectUserCredentials();
		    try {
				currentUser = authenticationService.login(credentials);
				userService.AUTH_TOKEN = currentUser.getToken();
			} catch (AuthenticationServiceException e) {
				System.out.println("LOGIN ERROR: "+e.getMessage());
				System.out.println("Please attempt to login again.");
			}
		}
	}
	
	private UserCredentials collectUserCredentials() {
		String username = console.getUserInput("Username");
		String password = console.getUserInput("Password");
		return new UserCredentials(username, password);
	}
	
	private Set<Integer> populateTransferIdSet(Transfer[] transfers){
		
		Set<Integer> transferIds = new HashSet<>();
		for(Transfer transfer : transfers) {
			transferIds.add(transfer.getTransferId());
			
		}
		
		return transferIds;
	}
	
	private void printTransfers(Transfer[] transfers) throws UserServiceException {
		
		System.out.println("----------------------------------------------");
		System.out.println("Transfers");
		System.out.format("%-10s %-27s %-10s", "Id", "From/To", "Amount");
		System.out.println();
		System.out.println("----------------------------------------------");
		
		
		int currentUserId = currentUser.getUser().getId();
		
		for(Transfer transfer: transfers) {
			
			
			String fromTo = "";
			String otherParty = "";
			int transferFromId;
			int transferToId;
			int transferTypeId;
			transferToId = transfer.getAccountTo();
			transferFromId = transfer.getAccountFrom();
			transferTypeId = transfer.getTransferTypeId();
			
			
			
			
			if(transferTypeId == 2  && currentUserId == transferFromId) {
				
				fromTo = "To: ";
				otherParty = userService.getUserById(transferToId).getUsername();
				
			} else if (transferTypeId == 2 && currentUserId == transferToId){
				
				fromTo = "From: ";
				
				otherParty = userService.getUserById(transferFromId).getUsername();
				
			}
			
			
		System.out.format("%-10s %-7s %-20s %-10s", transfer.getTransferId(), fromTo, otherParty,  "$" + transfer.getAmount());
		System.out.println();
			
		}
		
		System.out.println("----------");
		
		
	}
	
	private void printUsersHeading() {
		System.out.println("\n-------------------------------------------");
		System.out.println("Users");
		System.out.printf("%-15s%-30s", "ID", "Name");
		System.out.println("\n-------------------------------------------");
	}
	
	private void printSingleTransferDetails(Transfer transfer) {
		System.out.println("----------------------------------");
		System.out.println("Transfer Details");
		System.out.println("----------------------------------");
		

		int currentUserId = currentUser.getUser().getId();
		
		String from = "";
		String to = "";
		String transferType = "";
		String transferStatus = "";
		int transferFromId;
		int transferToId;
		int transferTypeId;
		transferToId = transfer.getAccountTo();
		transferFromId = transfer.getAccountFrom();
		transferTypeId = transfer.getTransferTypeId();
		
		
		try {
			if(transferTypeId == 2  && currentUserId == transferFromId) {
				
				from = "From: " + currentUser.getUser().getUsername();
				to = "To: " + userService.getUserById(transferToId).getUsername();
				
				
			} else if (transferTypeId == 2 && currentUserId == transferToId){
				
				from = "From: " + userService.getUserById(transferFromId).getUsername();
				to = "To: " + currentUser.getUser().getUsername();
				
			}
			
			
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		if(transferTypeId == 2) {
			
			transferType = "Send";
			
		}
		
		if(transfer.getTransferStatusId() == 2) {
			
			transferStatus = "Approved";
		}
		
		System.out.print("Id: "+ transfer.getTransferId() 
				+ "\n" + from
				+ "\n" + to
				+ "\nType: " + transferType
				+ "\nStatus: " + transferStatus
				+ "\nAmount: $" + transfer.getAmount() +"\n");
		
	}
	
}

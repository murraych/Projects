package com.techelevator.auction;

import com.techelevator.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import com.techelevator.models.Auction;

import java.util.Map;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    public static void main(String[] args) {
        int menuSelection;
        int auctionId = -1;

        ConsoleService consoleService = new ConsoleService();
        AuctionService auctionService = new AuctionService(API_BASE_URL);
        AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

        while (true) {
            menuSelection = consoleService.printMainMenu();
            try {
                if (menuSelection == 1) {
                    consoleService.printAuctions(auctionService.getAll());
                } else if (menuSelection == 2) {
                    Auction[] auctions = auctionService.getAll();
                    if (auctions != null) {
                        auctionId = consoleService.promptForAuction(auctions, "View");
                        if (auctionId != 0) {
                            Auction auction = auctionService.getOne(auctionId);
                            if (auction != null) {
                                consoleService.printAuction(auctionService.getOne(auctionId));
                            }
                        }
                    }
                } else if (menuSelection == 3) {
                    String title = consoleService.promptForAuctionTitle();
                    if (title != null) {
                        Auction[] auctions = auctionService.getByTitle(title);
                        if (auctions != null) {
                            consoleService.printAuctions(auctions);
                        }
                    }
                } else if (menuSelection == 4) {
                    double price = consoleService.promptForAuctionPrice();
                    if (price != 0.0) {
                        Auction[] auctions = auctionService.getByPrice(price);
                        if (auctions != null) {
                            consoleService.printAuctions(auctions);
                        }
                    }
                } else if (menuSelection == 5) { // Add auction
                    String newAuctionString = consoleService.promptForAuctionData();
                    Auction auction = auctionService.add(newAuctionString);
                    // if unsuccessful
                    if (auction == null) {
                        System.out.println("Invalid auction. Please enter the Title, Description, User, Current Bid Price (no dollar sign).");
                    } else {
                        // Print all auctions every time - provides confirmation of action
                        Auction[] auctions = auctionService.getAll();
                        if (auctions != null) {
                            consoleService.printAuctions(auctions);
                        }
                    }
                } else if (menuSelection == 6) {
                    Auction[] auctions = auctionService.getAll();
                    if (auctions != null) {
                        auctionId = consoleService.promptForAuction(auctions, "Update");
                        Auction auction = auctionService.getOne(auctionId);
                        if (auction != null) {
                            String CSV = consoleService.promptForAuctionData(auction);
                            auction = auctionService.update(CSV);
                            // if unsuccessful
                            if (auction == null) {
                                System.out.println("Invalid auction. Please enter the Title, Description, User, Current Bid Price (no dollar sign).");
                            } else {
                                // Print all locations every time - provides confirmation of action
                                auctions = auctionService.getAll();
                                if (auctions != null) {
                                    consoleService.printAuctions(auctions);
                                }
                            }
                        }
                    }
                } else if (menuSelection == 7) {
                    Auction[] auctions = auctionService.getAll();
                    if (auctions != null) {
                        auctionId = consoleService.promptForAuction(auctions, "Delete");
                        try {
                            auctionService.delete(auctionId);
                            // Print all locations every time - provides confirmation of action
                            consoleService.printAuctions(auctionService.getAll());
                        } catch (RestClientResponseException ex) {
                            consoleService.printError("Auction may not have been deleted. Please try again.");
                        } catch (ResourceAccessException ex) {
                            consoleService.printError("A network error occurred.");
                        }
                    }
                } else if (menuSelection == 8) {
                    String credentials = consoleService.promptForLogin();
                    if( credentials.split(",").length == 2 ) {
                        ResponseEntity<Map> response = authenticationService.login(credentials);
                        if (response.hasBody()) {
                            String token = (String) response.getBody().get("token");
                            auctionService.AUTH_TOKEN = token;
                            System.out.println("Login Successful");
                        }
                    } else {
                        consoleService.printError("Please enter username and password separated by a comma.");
                    }
                } else if (menuSelection == 0) { // Exit
                    consoleService.exit();
                } else { // defensive programming: anything else is not valid
                    System.out.println("Invalid Selection");
                }

                if (auctionId != 0) {
                    consoleService.next();
                }
            } catch (AuthenticationServiceException ex) {
                consoleService.printError(ex.getMessage());
                consoleService.next();
            } catch (AuctionServiceException ex) {
                consoleService.printError(ex.getMessage());
                consoleService.next();
            } catch (ResourceAccessException ex) {
                consoleService.printError(ex.getMessage());
                consoleService.next();
            }

            // Ensure loop continues
            menuSelection = 999;

        }

    }
}

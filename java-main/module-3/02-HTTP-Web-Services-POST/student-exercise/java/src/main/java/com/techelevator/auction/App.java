package com.techelevator.auction;

import com.techelevator.models.Auction;
import com.techelevator.services.AuctionService;
import com.techelevator.services.ConsoleService;

public class App {

    public static void main(String[] args) {
        int menuSelection;
        int auctionId = -1;

        ConsoleService consoleService = new ConsoleService();
        AuctionService auctionService = new AuctionService("http://localhost:3000/auctions");


        while (true) {
            menuSelection = consoleService.printMainMenu();
            if (menuSelection == 1) {
                consoleService.printAuctions(auctionService.getAll());
            } else if (menuSelection == 2) {
                auctionId = consoleService.promptForAuction(auctionService.getAll(), "View");
                if (auctionId != 0) {
                    consoleService.printAuction(auctionService.getOne(auctionId));
                }
            } else if (menuSelection == 3) {
                String title = consoleService.promptForAuctionTitle();
                if (title != null) {
                    consoleService.printAuctions(auctionService.getByTitle(title));
                }
            } else if (menuSelection == 4) {
                double price = consoleService.promptForAuctionPrice();
                if (price != 0.0) {
                    consoleService.printAuctions(auctionService.getByPrice(price));
                }

            } else if (menuSelection == 5) { // Add auction
                String newAuctionString = consoleService.promptForAuctionData();
                Auction auction = auctionService.add(newAuctionString);
                // if unsuccessful
                if (auction == null) {
                    System.out.println("Invalid auction. Please enter the Title, Description, User, Current Bid Price (no dollar sign).");
                } else {
                    // Print all auctions every time - provides confirmation of action
                    consoleService.printAuctions(auctionService.getAll());
                }
            } else if (menuSelection == 6) { // Update location
                auctionId = consoleService.promptForAuction(auctionService.getAll(), "Update");
                String CSV = consoleService.promptForAuctionData(auctionService.getOne(auctionId));
                Auction auction = auctionService.update(CSV);
                // if unsuccessful
                if (auction == null) {
                    System.out.println("Invalid auction. Please enter the Title, Description, User, Current Bid Price (no dollar sign).");
                } else {
                    // Print all locations every time - provides confirmation of action
                    consoleService.printAuctions(auctionService.getAll());
                }
            } else if (menuSelection == 7) { // Delete location
                auctionId = consoleService.promptForAuction(auctionService.getAll(), "Delete");
                auctionService.delete(auctionId);
                // Print all locations every time - provides confirmation of action
                consoleService.printAuctions(auctionService.getAll());
            } else if (menuSelection == 0) { // Exit
                consoleService.exit();
            } else { // defensive programming: anything else is not valid
                System.out.println("Invalid Selection");
            }
            // Press any key to continue...
            if (auctionId != 0) {
                consoleService.next();
            }
        }
    }
}

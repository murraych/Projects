package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private Menu menu;
	private List<Inventory> inventoryList = new ArrayList<>();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		// load in the inventory file. load inventory into the inventory list

		File inputFile = new File("vendingmachine.csv");
		Scanner fileScanner = new Scanner(inputFile); // creates the stream in order to open the file

//		while there is content on the next line, loops through one line at a time, splitting information
//		by the pipe and adds to an array lineInput
		while (fileScanner.hasNextLine()) {
			String[] lineInput = fileScanner.nextLine().split("\\|");

			if (lineInput[3].equals("Chip")) {
				// instantiates new chip with the 3 data members populated from the input file
				inventoryList.add(new Chip(lineInput[0], lineInput[1], Double.parseDouble(lineInput[2])));
			} else if (lineInput[3].equals("Drink")) {
				inventoryList.add(new Drink(lineInput[0], lineInput[1], Double.parseDouble(lineInput[2])));
			} else if (lineInput[3].equals("Candy")) {
				inventoryList.add(new Candy(lineInput[0], lineInput[1], Double.parseDouble(lineInput[2])));
			} else if (lineInput[3].equals("Gum")) {
				inventoryList.add(new Gum(lineInput[0], lineInput[1], Double.parseDouble(lineInput[2])));
			}
		}
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				
				displayItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				Transaction myTransaction = new Transaction();

				while (true) {
					System.out.println("\nCurrent balance: $" + String.format("%.2f", myTransaction.getBalance()));
					choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

						try {
							Scanner feedMoneyInput = new Scanner(System.in);
							System.out.println("Please feed money in valid, whole dollar amounts. (1, 2, 5, 10): ");
							int moneyEntered = Integer.parseInt(feedMoneyInput.nextLine());
							
							if (!myTransaction.isMoneyWholeDollarAmount(moneyEntered)) {
								throw new NumberFormatException();
							} else {
								myTransaction.feedMoney(moneyEntered);
								
								
								try {
									transactionLog("FEED", "MONEY:", (double) moneyEntered, myTransaction.getBalance());
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} catch (NumberFormatException e) {
							System.out.println("Machine only accepts money in $1, $2, 5, or $10 bills.");
						}

					} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {


						displayItems();

						Scanner slotLocationInput = new Scanner(System.in);
						System.out.println("\nPlease select a Slot Location by entering a valid code between A1-D4: ");
						String productCode = slotLocationInput.nextLine();

						boolean productCodeExists = false;
						for (Inventory items : inventoryList) {
							if (productCode.equalsIgnoreCase(items.getSlotLocation())) {
								productCodeExists = true;

								if (items.getStock() == 0) {
									System.out.println("This item is sold out. Please choose another item.");
									} 
								else if (myTransaction.getBalance() < items.getPrice()) {
									System.out.println("You do not have enough money. Please feed additional money!");
								}
								
								else {
									// decrement stock
									items.updateStock();
									// purchase item and update balance
									myTransaction.purchaseTransaction(items.getPrice());
									System.out.print(String.format("%s | $%.2f | $%.2f \n%s", items.getProductName(),
											items.getPrice(), myTransaction.getBalance(), items.getSound()));
									// record transaction to Log.txt File
									try {
										transactionLog(items.getProductName(), items.getSlotLocation(),
												items.getPrice(), myTransaction.getBalance());
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}

						if (!productCodeExists) {
							System.out.println("This is not a valid option. Please try again.");
						}

					} else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {

						// record transaction to Log.txt File and set above makeChange method in order
						// to use getBalance before reset to $0
						try {
							transactionLog("GIVE", "CHANGE", myTransaction.getBalance(), 0.00);
						} catch (Exception e) {
							e.printStackTrace();
						}

						myTransaction.makeChange(myTransaction.getBalance());

						break;
					}
				}

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(1);
			}
		}
	}

	public void transactionLog(String text1, String text2, double money1, double money2) throws Exception {

		Logger myLogger = new Logger("Log.txt");
		myLogger.Write(LocalDate.now() + " " + LocalTime.now() + " " + text1 + " " + text2 + " "
				+ String.format("$%.2f $%.2f", money1, money2));
	}
	
	public void displayItems() {
		System.out.print("\n");
		for (Inventory items : inventoryList) {
			if (items.getStock() < 1) {
				System.out.println(items.getSlotLocation() + " " + items.getProductName() + " Sold Out");
			} else {
				System.out.println(
						items.getSlotLocation() + " " + items.getProductName() + " " + items.getPrice());
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

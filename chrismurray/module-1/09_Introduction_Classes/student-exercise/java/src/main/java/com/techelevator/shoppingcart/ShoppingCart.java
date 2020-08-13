package com.techelevator.shoppingcart;

public class ShoppingCart {


private int totalNumberOfItems = 0;
private double totalAmountOwed = 0.00;


public void empty() {
	totalNumberOfItems = 0;
	totalAmountOwed = 0;
}

public void addItems(int numberOfItems, double pricePerItem) {
	totalNumberOfItems = numberOfItems;
	totalAmountOwed = pricePerItem * numberOfItems;
}

public double getAveragePricePerItem() {
	if (totalNumberOfItems == 0) {
		return 0;
	}
	else { return totalAmountOwed / totalNumberOfItems;
	
	}
}




public int getTotalNumberOfItems() {
	return totalNumberOfItems;
}
public double getTotalAmountOwed() {
	return totalAmountOwed;
}


	
	
}

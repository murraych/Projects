package com.techelevator;

public class AuctionDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Auction item1 = new Auction("Purple Water glass");
		Bid margaretsBid = new Bid("Margaret", 2);
		item1.placeBid(margaretsBid);
		
		
		
	}

}

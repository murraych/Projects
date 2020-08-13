package com.techelevator.auctions.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

	private AuctionDAO dao;

	public AuctionController() {
		this.dao = new MemoryAuctionDAO();
	}

	@RequestMapping(method = RequestMethod.GET) // why do i need title_like. I used title does .equals "" mean empty or
												// null?
	public List<Auction> list(@RequestParam(defaultValue = "", required = false) String title_like,
								@RequestParam(defaultValue = "0.0") Double currentBid_lte) {
		
		
		if (currentBid_lte > 0 && !title_like.equals("")) {
			return dao.searchByTitleAndPrice(title_like, currentBid_lte);
		}
		
		else if (currentBid_lte > 0) {
			return dao.searchByPrice(currentBid_lte);
		}
		
		else if (title_like.equals("")) {
			return dao.list(); // do i need dao or this.dao
		} 
		
		else {

			return dao.searchByTitle(title_like);
		}
		
		
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Auction getAuction(@PathVariable int id) {
		return dao.get(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Auction createAuction(@RequestBody Auction auction) {
		return dao.create(auction);
	}

}

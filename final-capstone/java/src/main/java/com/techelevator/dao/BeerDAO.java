package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Beer;

public interface BeerDAO {
	List<Beer> getBeers();
	Beer getBeerById(int breweryId, int id);
	void addBeer(Beer newBeer);
	void deleteBeer(int id);
	void deleteBeersByBrewery(int breweryId);
	//List<Beer> getAllGlutenFreeBeers();

	void updateBeer(Beer beerToUpdate);
	
}

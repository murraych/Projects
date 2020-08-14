package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

public interface BreweryDAO {

	List<Brewery> getAllBreweries();
	Brewery getBreweryById(int id);
	void createBrewery(Brewery newBrewery);
	void deleteBrewery(int id);
	void updateBrewery(Brewery aBrewery);
	List<Beer> getBeersByBreweryId(int breweryId);
	List<Brewery> getAllBreweriesWithGFBeer();
}

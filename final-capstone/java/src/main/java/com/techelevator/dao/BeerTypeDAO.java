package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.BeerType;

public interface BeerTypeDAO {
	List<BeerType> listAllBeerTypes();
	void updateBeerType(BeerType type);
	void addNewBeerType(BeerType newType);
	void deleteBeerType(int id);
}

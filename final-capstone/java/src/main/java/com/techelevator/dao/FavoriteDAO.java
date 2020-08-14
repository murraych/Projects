package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Favorite;

public interface FavoriteDAO {

	List<Favorite> listAllFavorites(int userId);
	void addFavorite(Favorite favorite);
	void removeFavorite(int userId, int breweryId);
	void removeFavoritesByBrewery(int breweryId);
	int deleteFavoritesByUserId(int userId);
	
}

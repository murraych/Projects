package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.FavoriteDAO;
import com.techelevator.model.Favorite;

@RestController
@CrossOrigin
public class FavoriteController {

	@Autowired
	FavoriteDAO favorites;
	
	
	@GetMapping(path = "/favorite/{userId}")
	public List<Favorite> getAllFavorites(@PathVariable int userId){
		List<Favorite> allFavorites = favorites.listAllFavorites(userId);
		return allFavorites;
	}
	
	@PostMapping(path = "/favorite")
	@ResponseStatus(HttpStatus.CREATED)
	public void addFavorite(@RequestBody Favorite favorite) {
		favorites.addFavorite(favorite);
	}
	
	@DeleteMapping(path = "/favorite/{userId}/{breweryId}")
	public void removeFavorite(@PathVariable int userId, @PathVariable int breweryId) {
		favorites.removeFavorite(userId, breweryId);
	}
	
	@DeleteMapping(path="/favorite/{breweryId}")
	public void removeFavoritesByBrewery(@PathVariable int breweryId) {
		favorites.removeFavoritesByBrewery(breweryId);
	}
	
	@DeleteMapping(path="/{userId}/favorites/delete")
	public void removeFavoritesByUser(@PathVariable int userId) {
		favorites.deleteFavoritesByUserId(userId);
	}
}

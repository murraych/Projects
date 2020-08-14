package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.BeerDAO;
import com.techelevator.model.Beer;

@RestController
@CrossOrigin
public class BeerController {
	@Autowired
	BeerDAO theBeers;

	@GetMapping(path= {"/beers"})
	public List<Beer> returnAllBeers(){
		List<Beer> beerList = theBeers.getBeers();
		return beerList;
	}
	
	@GetMapping(path="/breweries/{breweryId}/beers/{id}")
	public Beer getBeerById(@PathVariable int breweryId, @PathVariable int id) {
		Beer beer = theBeers.getBeerById(breweryId, id);
		return beer;
	}
	
	
	@PostMapping(path= {"/beers"})
	@ResponseStatus(HttpStatus.CREATED)
	public void addBeer(@RequestBody Beer newBeer) {
		theBeers.addBeer(newBeer);
	}
	
	@DeleteMapping(path="/beers/{id}")
	public void deleteBeer(@PathVariable int id) {
		theBeers.deleteBeer(id);
	}
	
	@DeleteMapping(path="/{breweryId}/beers")
	public void deleteBeers(@PathVariable int breweryId) {
		theBeers.deleteBeersByBrewery(breweryId);
	}
	
	@PutMapping(path="/updateBeer")
	@ResponseStatus(HttpStatus.OK)
	public void updateBeer(@RequestBody Beer beerToUpdate) {
		theBeers.updateBeer(beerToUpdate);
	}
	
//	@GetMapping(path="/beers/glutenFree")
//	public List<Beer> getAllGlutenFree() {
//		List<Beer> beers = theBeers.getAllGlutenFreeBeers();
//		return beers;
//	}
	
}

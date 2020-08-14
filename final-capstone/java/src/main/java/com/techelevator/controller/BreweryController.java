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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.BreweryDAO;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

@RestController
@CrossOrigin
public class BreweryController {
	@Autowired
	BreweryDAO breweries;
	
	@GetMapping(path= {"/breweries"})
	public List<Brewery> returnAllBreweries(){
		List<Brewery> breweryList = breweries.getAllBreweries();
		return breweryList;
	}
	
	@GetMapping(path="/breweries/{id}")
	public Brewery getBreweryById(@PathVariable int id) {
		Brewery aBrewery = breweries.getBreweryById(id);
		return aBrewery;
	}
	
	@GetMapping(path="/breweries/{breweryId}/beers")
	public List<Beer> getBeersByBreweryId(@PathVariable int breweryId) {
		List<Beer> beerList = breweries.getBeersByBreweryId(breweryId);
		return beerList;
	}
	
	@PostMapping(path= {"/breweries"})
	@ResponseStatus(HttpStatus.CREATED)
	public void addBrewery(@RequestBody Brewery newBrewery) {
		breweries.createBrewery(newBrewery);
	}
	
	@PutMapping(path="/updateBrewery")
	@ResponseStatus(HttpStatus.OK)
	public void updateBrewery(@RequestBody Brewery breweryToUpdate) {
		breweries.updateBrewery(breweryToUpdate);
	}
	
	@DeleteMapping(path="/breweries/{id}")
	public void deleteBrewery(@PathVariable int id) {
		breweries.deleteBrewery(id);
	}
	
	@GetMapping(path="/breweries/glutenfree")
	public List<Brewery> getAllGlutenFreeBeers(){
		List<Brewery> glutenFreeBeers = breweries.getAllBreweriesWithGFBeer();
		return glutenFreeBeers;
	}
	
	
}

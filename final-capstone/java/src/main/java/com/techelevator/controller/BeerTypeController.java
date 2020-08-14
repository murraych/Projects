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

import com.techelevator.dao.BeerTypeDAO;
import com.techelevator.model.BeerType;

@RestController
@CrossOrigin
public class BeerTypeController {
	@Autowired
	BeerTypeDAO types;
	
	@GetMapping(path="/beertypes")
	public List<BeerType> listAllTypes(){
		List<BeerType> allTypes = types.listAllBeerTypes();
		return allTypes;
	}
	
	@PostMapping(path="/beertypes")
	@ResponseStatus(HttpStatus.CREATED)
	public void createBeerType(@RequestBody BeerType newType) {
		types.addNewBeerType(newType);
	}
	
	@PutMapping(path="/beertypes/update")
	@ResponseStatus(HttpStatus.OK)
	public void updateBeerType(@RequestBody BeerType type) {
		types.updateBeerType(type);
	}
	
	@DeleteMapping(path="/beertypes/{id}")
	public void deleteBeerType(@PathVariable int id) {
		types.deleteBeerType(id);
	}
	
	
	

	
}

package com.techelevator.controller;


import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PuppyDao;
import com.techelevator.model.Puppy;

/**
 * PuppiesController
 */
/**
 * ApiController
 */
@RestController          // identifies the controller a REST api controller - can be called from web service
@RequestMapping("/api")  // Identify root path for all controllers in the - just like it did before
@CrossOrigin   
public class PuppiesController {
	
	@Autowired
	PuppyDao thePuppies;
	
	@GetMapping(path= {"/allPuppies", "/"})   // indicates this method with handle HTTP GET requests for the allPuppies
	public List<Puppy> returnPuppyData()  {
		
		logTimestamp();                                    // log time of request	
		List<Puppy> allPuppies = thePuppies.getPuppies();  // Get all puppies from data base
		
		return allPuppies;                                 // return the data requested rather than the view name
	}

	@GetMapping("/puppy/{id}")   // indicates this method with handle HTTP GET requests for the /puppy with id of Puppy to retreive
	public Puppy returnPuppyById(@PathVariable int id) {
    
		logTimestamp();                              // log time of request	
		
		Puppy aPuppy = thePuppies.getPuppy(id);      // Get the puppie with the supplied id from the database
		
		return aPuppy;                               // return the data requested rather than the view name
	}
	
	@DeleteMapping("/removePuppy/{id}")   // indicates this method with handle HTTP Delete requests for the /remove with id of Puppy to retreive
	@ResponseStatus(HttpStatus.OK)
	public void removePuppyById(@PathVariable int id) {
	
		logTimestamp();               // log time of request	
		thePuppies.removePuppy(id);	  // remove the puppie with the given id form the data base
	}
	
	@PostMapping("/newPuppy")   // indicates this method with handle HTTP POST requests for the /newPuppy
	@ResponseStatus(HttpStatus.CREATED)
	public void newPuppy(@RequestBody Puppy aPuppy) {
		logTimestamp();               // log time of request
		thePuppies.savePuppy(aPuppy); // add the puppy passed in to the database
	}
	
	@PutMapping("/editPuppy")   // indicates this method with handle HTTP POST requests for the /newPuppy
	@ResponseStatus(HttpStatus.OK)
	public void editPuppy(@RequestBody Puppy aPuppy) {
		System.out.println("editing a puppy!");
		logTimestamp();               // log time of request					
		thePuppies.editPuppy(aPuppy); // add the puppy passed in to the database
	}
	
	
	static void logTimestamp() {    // log timestamp of request to Console
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
		System.out.println("Howdy from the Java Puppy REST API at " + timestamp);
	}
}

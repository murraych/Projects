package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PuppyDAO;
import com.techelevator.model.Puppy;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PuppyController {

	@Autowired
	PuppyDAO thePuppies;
	
	@RequestMapping(path = { "/allPuppies", "/"} )
	public List<Puppy> listAllPuppies(){
		List<Puppy> allPuppies = thePuppies.getAllPuppies();
		return allPuppies;
	}

}

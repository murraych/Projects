package com.techelevator.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.techelevator.model.Puppy;

/**
 * PuppyDao
 */
public interface PuppyDao {

    List<Puppy> getPuppies();

    Puppy getPuppy(int id);

    void savePuppy(Puppy puppyToSave);

	void removePuppy(int id);
	
	void editPuppy(Puppy puppyToSave);
}
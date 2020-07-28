package com.techelevator;

import java.util.List;

public interface CampgroundDAO {
	
	
	//return all campgrounds in a list per a specific parkId
	public List<Campground> getAllCampgroundsByPark(Long parkId);

	
}

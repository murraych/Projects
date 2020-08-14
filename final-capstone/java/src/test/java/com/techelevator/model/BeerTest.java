package com.techelevator.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BeerTest {
	
	private Beer testBeer;
	
	@Before
	public void setUp(){
		testBeer = new Beer();
	}
	
	
	@Test
	public void sameBeersAreSame() {
		Beer actual = new Beer();
		assertEquals(testBeer.getId(), actual.getId());
		assertEquals(testBeer.getBreweryId(), actual.getBreweryId());
		assertEquals(testBeer.getName(), actual.getName());
		assertEquals(testBeer.getDescription(), actual.getDescription());
		assertEquals(testBeer.getImage(), actual.getImage());
		assertEquals(testBeer.getAbv(), actual.getAbv(), .01);
		assertEquals(testBeer.getBeerType(), actual.getBeerType());
		assertEquals(testBeer.getBeerTypeId(), actual.getBeerTypeId());
		assertEquals(testBeer.isGlutenFree(), actual.isGlutenFree());
		
	}
	
	@Test
	public void diffBeersAreDiff() {
		Beer actual = new Beer();
		actual.setGlutenFree(false);
		assertNotEquals(testBeer, actual);
	}

}

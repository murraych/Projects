package com.techelevator.model;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BreweryTest {

	private Brewery testBrewery;
	
	@Before
	public void setup() {
		testBrewery = new Brewery();
	}

	@Test
	public void sameBreweriesAreSame() {
		Brewery actual = new Brewery();
		assertEquals(testBrewery.getId(), actual.getId());
		assertEquals(testBrewery.getName(), actual.getName());
		assertEquals(testBrewery.getaddress1(), actual.getaddress1());
		assertEquals(testBrewery.getCity(), actual.getCity());
		assertEquals(testBrewery.getState(), actual.getState());
		assertEquals(testBrewery.getZipCode(), actual.getZipCode());
		assertEquals(testBrewery.getCountry(), actual.getCountry());
		assertEquals(testBrewery.getLongitude(), actual.getLongitude(), .01);
		assertEquals(testBrewery.getLatitude(), actual.getLatitude(), .01);
		assertEquals(testBrewery.getPhoneNumber(), actual.getPhoneNumber());
		assertEquals(testBrewery.getWebsite(), actual.getWebsite());
		assertEquals(testBrewery.getHistory(), actual.getHistory());
		assertEquals(testBrewery.getImage(), actual.getImage());
		assertEquals(testBrewery.getFoodId(), actual.getFoodId());
		assertEquals(testBrewery.isActive(), actual.isActive());
		
	}
	
	@Test
	public void differentBreweriesAreDiff() {
		Brewery actual = new Brewery();
		actual.setActive(false);
		assertNotEquals(testBrewery, actual);
	}

}

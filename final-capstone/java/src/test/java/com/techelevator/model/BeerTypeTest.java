package com.techelevator.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BeerTypeTest {
	
	private BeerType testBeerType;
	
	
	@Before
	public void setUp() {
		testBeerType = new BeerType();
	}
	
	@Test
	public void sameTypesAreSame() {
		BeerType actual = new BeerType();
		assertEquals(testBeerType.getId(), actual.getId());
		assertEquals(testBeerType.getName(), actual.getName());
	}
	
	@Test
	public void diffTypesAreDiff() {
		BeerType actual = new BeerType();
		actual.setName("wrong beer");
		assertNotEquals(testBeerType, actual);
	}

}

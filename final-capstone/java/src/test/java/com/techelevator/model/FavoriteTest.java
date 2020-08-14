package com.techelevator.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FavoriteTest {
	
	private Favorite testFavorite;
	
	@Before
	public void setUp() {
		testFavorite = new Favorite();
	}

	@Test
	public void sameFavesAreSame() {
		Favorite actual = new Favorite();
		assertEquals(testFavorite.getUserId(), actual.getUserId());
		assertEquals(testFavorite.getBreweryId(), actual.getBreweryId());
		assertEquals(testFavorite.getBreweryName(), actual.getBreweryName());
		
	}
	
	@Test
	public void diffFavesAreDiff() {
		Favorite actual = new Favorite();
		actual.setBreweryId(5);
		assertNotEquals(testFavorite, actual);
	}

}

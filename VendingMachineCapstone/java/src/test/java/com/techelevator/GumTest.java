package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class GumTest {

	Gum testGum = new Gum("A1", "Test Gum", 1);
	
	@Test
	public void DoesGumReturnCorrectString() {
		assertEquals("Chew Chew, Yum!", testGum.getSound());
	}
	
	@Test
	public void getProductName() {
		testGum.setProductName("Steve");
		assertEquals("Steve", testGum.getProductName());
	}
	
	@Test
	public void getSlotLocation() {
		testGum.setSlotLocation("A4");
		assertEquals("A4", testGum.getSlotLocation());
	}
	
	@Test
	public void getPrice() {
		testGum.setPrice(1.50);
		assertEquals(1.50, testGum.getPrice(), .001);
	}

	@Test
	public void getStock() {
		testGum.setStock(6);
		assertEquals(6, testGum.getStock());
	}
	
}

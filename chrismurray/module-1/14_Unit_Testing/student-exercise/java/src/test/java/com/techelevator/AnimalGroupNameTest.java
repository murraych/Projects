package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalGroupNameTest {

	
	AnimalGroupName group = new AnimalGroupName();
	
	@Test
	public void getHerdSendInGiraffeReturnTower() {

		
		String expected = "Tower";
		String actual = group.getHerd("giraffe");
		
		assertEquals(expected, actual);
		assertEquals("Crash", group.getHerd("rhino"));
		assertEquals("Crash", group.getHerd("RHINO"));
		assertEquals("unknown", group.getHerd(""));
		assertEquals("unknown", group.getHerd("walrus"));
		assertEquals("Herd", group.getHerd("elephant"));
		assertEquals("Herd", group.getHerd("lion"));
		assertEquals("unknown", group.getHerd("elephants"));
		assertEquals("Murder", group.getHerd("crow"));
		assertEquals("Kit", group.getHerd("pigeon"));
		assertEquals("Pat", group.getHerd("flamingo"));
		assertEquals("Herd", group.getHerd("deer"));
		assertEquals("Pack", group.getHerd("dog"));
		assertEquals("Murder", group.getHerd("crow"));
	
	}
		
	@Test
	public void animalNameIsNull() {
		String expected = "unknown";
		String actual = group.getHerd("");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getUppercaseReturnLowerCase() {
		String expected = "Pack";
		String actual = group.getHerd("DOG");
		assertEquals(expected, actual);
	}
	
	
}

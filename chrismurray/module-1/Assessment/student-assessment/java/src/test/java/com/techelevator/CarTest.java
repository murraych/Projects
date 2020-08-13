package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;


public class CarTest {
	
	Car myCar = new Car(2000, "Ford", false);
	Car secondCar = new Car(2018, "Ferrari", false);
	Car classicCar = new Car(1970, "Chevy", true);
	Car oldCar = new Car(1960, "Impala", false);
	Car oddCar = new Car(2015, "Ford", false);

	@Test
	public void getAge() {
		assertEquals(20, myCar.getAge());
	}

	@Test
	public void doesNeedECheck() {
		assertTrue(myCar.doesCarNeedECheck(2000));
		assertTrue(myCar.doesCarNeedECheck(2016));
		assertTrue(oddCar.doesCarNeedECheck(2017));
	}
	
	@Test
	public void doesNotNeedECheck() {
		
		assertFalse(secondCar.doesCarNeedECheck(2000));
		assertFalse(secondCar.doesCarNeedECheck(2019));
		assertFalse(classicCar.doesCarNeedECheck(2005));
		assertFalse(oldCar.doesCarNeedECheck(2020));
	}
	
}

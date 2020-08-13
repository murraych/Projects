package com.techelevator;

import java.math.BigDecimal;

public class BigDecimalExample {

	public static void main(String[] args) {

		// Create a BigDecimal object
		BigDecimal bd1 = new BigDecimal(120.99);
		
		BigDecimal bd2 = new BigDecimal("356.49");
		
		System.out.println("value of first is " + bd1 +
				"\nvalue of second is " + bd2);
		
		
		// adds to values together and then saves answer in bd1
		bd1 = bd1.add(bd2);
		System.out.println("now value is " + bd1);
		
		bd1 = bd1.subtract(new BigDecimal(5.99));
		System.out.println("now value is " + bd1.setScale(2, BigDecimal.ROUND_HALF_DOWN));
		
		System.out.println(bd1);
		
		BigDecimal bd3 = bd2.pow(4);
		System.out.println("bd2 raised to the 4th power is " + bd3);
		
		

	}

}

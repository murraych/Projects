package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemmoAPp {

	
	public static void main(String[] args) {
		
		List<Integer> myIntList = new ArrayList<>(Arrays.asList(34, 45, 56, 67)); // will intialize the array with 4 values
		
		myIntList.add(42);
		myIntList.remove(0);
		
		System.out.println("looping using for loop:");
		for(int i = 0; i < myIntList.size();i++) {
			System.out.println(myIntList.get(i));
		}
		
		System.out.println("\nlooping using a for each loop:");
		for (Integer i : myIntList) {
			System.out.println(i);
		}

	}

}

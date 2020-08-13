package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListDemoApp {


	public static void main(String[] args) {

		List<Integer> myIntList= 
			new ArrayList<>(Arrays.asList(34, 45, 56, 67));
		// will initialize the array with 4 values
		
		myIntList.add(42);
		
		myIntList.remove(0);
		
		System.out.println("looping using for loop:");
		for (int i = 0; i < myIntList.size();i++) {
			System.out.println(myIntList.get(i));
		}
		
		System.out.println("\nlooping using a for each loop:");
		for (Integer i : myIntList) { 
			System.out.println(i);
		}
		
		Map<String, Integer> myMap = new HashMap<>();
		
		myMap.put("one", 1);
		myMap.put("two", 2);
		myMap.put("three", 3);
		myMap.put("four", 4);
		
		// need to create a keySet in order to loop through and 
		// get the map entries
		
		Set<String> keys = myMap.keySet(); // keys will hold all the keys from the map
		
		for (String key : keys) {
			System.out.print(key + " ");
			System.out.println(myMap.get(key));
		}
		


	}

}

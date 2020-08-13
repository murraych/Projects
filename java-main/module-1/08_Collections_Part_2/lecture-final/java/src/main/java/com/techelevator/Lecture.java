package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();

		/* Map is an interface and HashMap is a class that implements Map */
		Map <String, String> nameToZip = new HashMap<>(); 

		/* The "put" method is used to add elements to a Map */
		nameToZip.put("Joe", "10101");
		nameToZip.put("Jim", "48202");
		nameToZip.put("Tim", "48232");

		System.out.println(nameToZip);  // unordered means we do not know the order in which the element will return
		System.out.println();
		/* The "get" method is used to retrieve elements from a Map */
		String zipCode = nameToZip.get("Jim");  // returned the value associated the key of "Jim"
		System.out.println("Jim lives in " + zipCode);
		System.out.println("Tim lives in " + nameToZip.get("Tim"));
		zipCode = "48234";
		nameToZip.put("Jim", zipCode);  // replaces the old value in the key location in the map called nameToZip
		
		System.out.println(nameToZip);   // zipCode for Jim is now changed
		System.out.println();
		
	
		/* keySet returns a Set of all of the keys in the Map */
		Set<String> keys = nameToZip.keySet();
		System.out.println();
		for (String name: keys) {  // for each name in my set of keys
			System.out.println(name + " lives in " + nameToZip.get(name));  // print the name and the value associated
			nameToZip.put(name, "22002");  // this would 
		}
		 
		/*  Entry Set example  */
		System.out.println("\nPrinting using an Entry set: ");
		Set<Entry<String, String>> entries = nameToZip.entrySet();
		
		for (Map.Entry<String, String> entry: entries) {
			String name = entry.getKey();
			String zip = entry.getValue();
			
			System.out.println(name + " lives in " + zip);
		}
	
		/* If the key already exists, put will overwrite the existing value with the new value */
		// see line above with the put of the new zipcode

		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();

		Set<String> students  = new HashSet<>();

		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();
		
		students.add("Jim");
		students.add("Joe");
		students.add("Ann");
		
		System.out.println(students);
		students.add("Ann");

		System.out.println(students);

		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();



	}

}

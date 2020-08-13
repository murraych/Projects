package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exercises {

	/*
	 * Map Exercises
	 */

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		
		Map <String, String> animalMap = new HashMap<>();
	
		animalMap.put("rhino", "Crash");
		animalMap.put("giraffe", "Tower");
		animalMap.put("elephant", "Herd");
		animalMap.put("lion", "Pride");
		animalMap.put("crow", "Murder");
		animalMap.put("pigeon", "Kit");
		animalMap.put("flamingo", "Pat");
		animalMap.put("deer", "Herd");
		animalMap.put("dog", "Pack");
		animalMap.put("crocodile", "Float");
		
		String animals = animalName.toLowerCase();
		
	
		if (!animalMap.containsKey(animals)) {
			return "unknown";
		}
		
		return animalMap.get(animals);
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public Double isItOnSale(String itemNumber) {
		
		Map<String, Double> saleMap = new HashMap <>();
		saleMap.put("kitchen4001", 0.20);
		saleMap.put("garage1070", 0.15);
		saleMap.put("livingroom", 0.10);
		saleMap.put("kitchen6073", 0.40);
		saleMap.put("bedroom3434", 0.60);
		saleMap.put("bath0073", 0.15);
		
		String rooms = itemNumber.toLowerCase();
		
		if (itemNumber == "" || itemNumber == "null") {
			return 0.00;
		}
		if (!saleMap.containsKey(rooms)) {
			return 0.00;
		}
		return saleMap.get(rooms);
	}

	/*
	 * Modify and return the given map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		int peterMoney = peterPaul.get("Peter");
		int paulMoney =	peterPaul.get("Paul");
		
		if (peterMoney > 0 && paulMoney < 1000) {
			Integer petersMoney50 = peterMoney /2 ;
			
			peterPaul.put("Paul", (petersMoney50 + paulMoney));
			peterPaul.put("Peter", (peterMoney - petersMoney50));
			
		}
		
		return peterPaul;
	}

    /*
	 * Modify and return the given map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 * 
	 * peterPaulPartnership({"Peter": 5000, "Paul": 10000}) → {"Peter": 3750, "Paul": 7500, "PeterPaulPartnership": 3750}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		int peterMoney = peterPaul.get("Peter");
		int paulMoney =	peterPaul.get("Paul");
		
		if (peterMoney >= 5000 && paulMoney >= 10000){
			int peterMoney25 = peterMoney / 4;
			int paulMoney25 = paulMoney / 4;
			peterPaul.put("Paul", paulMoney - paulMoney25);
			peterPaul.put("Peter", peterMoney - peterMoney25);
			peterPaul.put("PeterPaulPartnership", peterMoney25 + paulMoney25);
		}
		
		
		return peterPaul;
	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> where for every different string in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		String firstCharacter = "";
		String lastCharacter = "";
		Map<String, String> firstLast = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			firstCharacter = "" + words[i].charAt(0);
			lastCharacter = "" + words[i].charAt(words[i].length() - 1);
			firstLast.put(firstCharacter,  lastCharacter);
		}
	
		
		
		return firstLast;
	}

	/*
	 * Given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the
	 * number of times that string appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> wordMap = new HashMap<>();
		
		
		for (String temp: words) {
			if (wordMap.containsKey(temp)) {
				int count = wordMap.get(temp);
				count++;
				wordMap.put(temp, count);
			}
			else {
				wordMap.put(temp, 1);
			}
		}
		
		
		return wordMap;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 1, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * integerCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * integerCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		
		Map<Integer, Integer> integerCount = new HashMap<>();
		
		for (int integer : ints) {
			if (integerCount.containsKey(integer)) {
				int count = integerCount.get(integer);
				count ++;
				integerCount.put(integer, count);
			}
			else {
				integerCount.put(integer, 1);
			}
			}
		
		return integerCount;
	}

	/*
	 * Given an array of strings, return a Map<String, Boolean> where each different string is a key and value
	 * is true only if that string appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		
		Map<String, Boolean> wordMultiple = new HashMap<>();
		int count = 0;
		for(String word : words ) {
			if (wordMultiple.containsKey(word)) {
			wordMultiple.put(word, true);	
			}
		else {
			wordMultiple.put(word, false);
		}
		}
		return wordMultiple;
	}

	/*
	 * Given two maps, Map<String, Integer>, merge the two into a new map, Map<String, Integer> where keys in Map2,
	 * and their Integer values, are added to the Integer values of matching keys in Map1. Return the new map.
	 *
	 * Unmatched keys and their Integer values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse, Map<String, Integer> remoteWarehouse) {
		
		Map<String, Integer> mapNew = new HashMap <>();
		Set <String> mainKeys = mainWarehouse.keySet();
		Set <String> remoteKeys = remoteWarehouse.keySet();
		
		for(String key: mainKeys) {
			if (remoteKeys.contains(key)) {
				mapNew.put(key, mainWarehouse.get(key) + remoteWarehouse.get(key));
			}
			else {
				mapNew.put(key, mainWarehouse.get(key));
			}
		}
		for (String key: remoteKeys) {
			if (!mainKeys.contains(key)) {
				mapNew.put(key, remoteWarehouse.get(key));
			}
		}
		
		return mapNew;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of strings, for each string, the count of the number of times that a substring length 2 appears
	 * in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1.
	 *
	 * We don't count the end substring, but the substring may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end substring, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is string from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		
		
		Map<String, Integer> doubleLetters = new HashMap<>();
		for(String temp: words) {
		
			int count = 0;
			for(int i = 0; i < temp.length() - 2; i++) {
				if (temp.substring(i, i + 2).equals(temp.substring(temp.length() - 2))) {
					count ++;
				}
			}
			doubleLetters.put(temp,  count);
		}
			return doubleLetters;
		
		
	}

	/*
	 Given a list of Strings, return a list that contains the distinct values. In other words, no value is to be
	 included more than once in the returned list. (Hint: Think Set)
	 distinctValues( ["red", "yellow", "green", "yellow", "blue", "green", "purple"] ) -> ["red", "yellow", "green", "blue", "purple"]
	 distinctValues( ["jingle", "bells", "jingle", "bells", "jingle", "all", "the", "way"] ) -> ["jingle", "bells", "all", "the", "way"]
	 */
	public List<String> distinctValues(List<String> stringList) {
		
		
		
		return null;
	}

}
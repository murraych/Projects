package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
	 array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
	 array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) {
		List <String> stringList = Arrays.asList(stringArray);
		return stringList;
	}

	/*
	 Given a list of Strings, return an array containing the same Strings in the same order
	 list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
	 list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
	 list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) {
		String[] stringArray = stringList.toArray(new String[stringList.size()]);
		
		return stringArray;
	}

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) {
		List <String> stringList = new ArrayList<String>();
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i].length() != 4 ) {
				stringList.add(stringArray[i]);

		}
		}
		
		return stringList;
	}

	/*
	 Given a List of Strings, return a new list in reverse order of the original. One obvious solution is to
	 simply loop through the original list in reverse order, but see if you can come up with an alternative
	 solution. (Hint: Think LIFO (i.e. stack))
	 reverseList( ["purple", "green", "blue", "yellow", "green" ])  -> ["green", "yellow", "blue", "green", "purple" ]
	 reverseList( ["jingle", "bells", "jingle", "bells", "jingle", "all", "the", "way"} )
		-> ["way", "the", "all", "jingle", "bells", "jingle", "bells", "jingle"]
	 */
	public List<String> reverseList(List<String> stringList) {
		
		Stack <String> newStack = new Stack<>();
		List <String> reversedList = new ArrayList<>();
		
		for (String newListElements : stringList) {
			newStack.push(newListElements);
		}
		
		while (newStack.size() > 0) {
			reversedList.add(newStack.pop());
		}
		
		
		return reversedList;
	}

	/*
	 Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
	 arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
	 arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
	 arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) {
		List <Double> arrayToDoubleList = new ArrayList<>();
		
		if (intArray.length > 0) {							// making sure the array is not empty
			double output = 0;								// setting a double variable 0, before we cycle through the for loop
			for(int i = 0; i < intArray.length; i++) {		// for loop that allows us to cycle through the entire array
			output = (double)intArray[i]/2;					// takes output (previously zero)
			arrayToDoubleList.add(output);	
			}
			
		} 
		return arrayToDoubleList;
	}

	/*
	 Given a List of Integers, return the largest value.
	 findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
	 findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
	 findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 64362
	 */
	public Integer findLargest(List<Integer> integerList) {
		
		int largestInt = 0;
		for (int i = 0; i < integerList.size(); i++) {
			if (integerList.get(i) > largestInt) {
				largestInt = integerList.get(i);
			}
			
		}
		
		return largestInt;
	}

	/*
	 Given an array of Integers, return a List of Integers containing just the odd values.
	 oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
	 oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
	 oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) {
		
		List<Integer> oddOnlyList = new ArrayList<>();
	
		
		for (int i = 0; i < integerArray.length; i++) {
			if (integerArray[i] % 2 != 0) {
				oddOnlyList.add(integerArray[i]);
			}
		}
		
		return oddOnlyList;
	}

	/*
	 Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 23, 44, 2, 88, 44], 44) -> true
	 */
	public boolean foundIntTwice(List<Integer> integerList, int intToFind) {
		
		int firstInt = 0;
		
		for(int temp: integerList) {
			if (temp == intToFind) {
				firstInt++;
			}
				}
		
		
		//return (counter >= 2);
		if (firstInt > 1) {
			return true;
		}
		return false;
	}

	/*
	 Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
	should be replaced by the String "Fizz", any multiple of 5 should be replaced by the String "Buzz",
	and any multiple of both 3 and 5 should be replaced by the String "FizzBuzz"
	** INTERVIEW QUESTION **
	
	fizzBuzzList( {1, 2, 3} )  ->  [1, 2, "Fizz"]
	 fizzBuzzList( {4, 5, 6} )  ->  [4, "Buzz", 6]
	 fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  [7, 8, "Fizz", "Buzz", 11, "Fizz", 13, 14, "FizzBuzz"]
	
	 HINT: To convert an integer x to a string you can call x.toString() in your code (e.g. if x = 1 then x.ToString()
	 equals "1")
	 */
	public List<String> fizzBuzzList(Integer[] integerArray) {
		
		List<String> newFizzList = new ArrayList<>();
		
		for(int temp: integerArray) {
			if (temp % 3 == 0 && temp % 5 == 0) {
				newFizzList.add("FizzBuzz");
			}
			else if (temp % 3 == 0) {
				newFizzList.add("Fizz");
			}
			else if (temp % 5 == 0) {
				newFizzList.add("Buzz");
			}
			else {
				newFizzList.add(temp + "");
			}
			
			
		}	
		return newFizzList;
	}

	/*
	 Given two lists of Integers, interleave them beginning with the first element in the first list followed
	 by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
	 Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
	 list to the new list before returning it.
	 interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
	 */
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {
		
		List<Integer> interList = new ArrayList<>(); //creating new list interList
		int minLength = 0;						// declaring minlength 
		int maxLength = 0;                        // declaring maxLength as an integer
		if (listOne.size() < listTwo.size()) {			//figuring out which list is greater in size in order  setting that size to minLength variable
			minLength = listOne.size();
			maxLength = listTwo.size();
		}
		else { 
			minLength = listTwo.size();
			maxLength = listOne.size();
		}
		for(int i = 0; i < minLength; i++) {			// for loop going through both loops until the smaller array is out
			interList.add(listOne.get(i));
			interList.add(listTwo.get(i));
			
		}
		for (int i = minLength; i < maxLength; i++) {
			if (listOne.size() > minLength) {
				interList.add(listOne.get(i));
			} else if(listTwo.size() > minLength) {
				interList.add(listTwo.get(i));
			}
		}
		
		return interList;
	}

	/*
	 Given a list of Integers representing seat numbers, group them into ranges 1-10, 11-20, and 21-30.
	 (Any seat number less than 1, or greater than 30 is invalid, and can be ignored.) Preserve the order
	 in which the seat number entered their associated group. Return a list of the grouped Integers 1-10,
	 11-20, and 21-30. (Hint: Think multiple queues)
	 boardingGate( [1, 13, 43, 22, 8, 11, 30, 2, 4, 14, 21] ) -> [1, 8, 2, 4, 13, 11, 14, 22, 30, 21]
	 boardingGate( [29, 19, 9, 21, 11, 1, 0, 25, 15, 5, 31] ) -> [9, 1, 5, 19, 11, 15, 29, 21, 25]
	 boardingGate( [0, -1, 44, 31, 17, 7, 27, 16, 26, 6] ) -> [7, 6, 17, 16, 27, 26]
	 */
	public List<Integer> boardingGate(List<Integer> seatNumberList) {
		Queue<Integer> smallQueue = new LinkedList<>(); // we use queues because they preserve the order
		Queue<Integer> mediumQueue = new LinkedList<>();
		Queue<Integer> largeQueue = new LinkedList<>();
		
		for(int number: seatNumberList) {	// for each integer in the seatNumberList which passed through
			if (number >=1 && number <=10) {
				smallQueue.offer(number);
			} else if (number >= 11 && number <=20) {
				mediumQueue.offer(number);
			} else if (number >= 21 && number <= 30) {
				largeQueue.offer(number);
			}
			
		}
		
		List<Integer> output = new ArrayList<>();
		output.addAll(smallQueue);
		output.addAll(mediumQueue);
		output.addAll(largeQueue);
		
		return output;
	}

}

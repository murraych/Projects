package com.techelevator;

import java.util.Arrays;

public class Lecture {

	public static void main(String[] args) {
		
		System.out.println("************************************");
		System.out.println("****** Making some Array objects ***");
		System.out.println("************************************");
		
		int[] myArray = new int[10];  // myArray is variable in the stack and references a location in the heap
		Arrays.fill(myArray, 7);  // fills entire array with 7s
		
		
		System.out.println(Arrays.toString(myArray));
		
		int[] newArray = Arrays.copyOf(myArray, 5);  // creates a new array called newArray that holds the first
													 // five values from myArray in it.
		
		System.out.println("newArray equals: " + Arrays.toString(newArray));
		
		newArray[0] = 99;
		newArray[2] = 42;
		newArray[3] = 2;
		newArray[4] = 11;   // changing values in our array 
		
		System.out.println("now the values are: " + Arrays.toString(newArray));
		
		Arrays.sort(newArray);
		
		System.out.println("\nAfter sort: " + Arrays.toString(newArray));
		

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */
		
		String myString = "Happy Monday"; // special treatment
		
		/* create an new instance of String using a literal */
		
		String anotherString = new String ("Tell me why I don't like Mondays?");
		
		System.out.println(myString);
		System.out.println(anotherString);
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		int myStringLength = myString.length();  // create a variable to hold the length integer
		System.out.println("Length of myString: " + myStringLength);
		
		System.out.println("Length of anotherString: " + anotherString.length());  // call the method inside the sout
		
		char charAtPosFive = myString.charAt(4);  
		System.out.println("Character in index 4: " + charAtPosFive);
		
		System.out.println("Character in index 6: " + anotherString.charAt(6));
		
		System.out.println("Substring of myString 0 - 5: " + myString.substring(0, 6));
		System.out.println("Substring of myString from 6 to the end: " + myString.substring(6));
		
		/* Other commonly used methods:
		 *
		 * endsWith -- checks to see if a string ends with particular string
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */
		
		System.out.println("Shouting: " + anotherString.toUpperCase());
		
		if(myString.toLowerCase().endsWith("ay")) {  //convert to lower case first and then check to see if ends with
			System.out.println("ends with ay!");
		} else {
			System.out.println("doesn't end with ay");
		}
		

		String myName = "Margaret";  // gives me a spot in the heap for myName that holds Margaret
		myName = myName + " Green";  // redeclares a new spot in the heap for myName and adds Green to the end
		
		String subStr = myName.substring(8);  //returns from position 8 to the end
		
		String subStr2 = myName.substring(myName.indexOf(" "));
		
		System.out.println(subStr);
		System.out.println(subStr2);
		if (subStr.endsWith("en")) {  
			System.out.println("Ends with en");
		}
		
		String lastName = myName.substring(9);
		String lastName2 = myName.substring(myName.indexOf(" ") + 1);  // returns only the last name
		
		System.out.println(lastName + "     " + lastName2);
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();


		String hello1 = "Well Hello!";
		
		// String hello2 = "Well Hello!";
		String hello2 = new String("Well Hello!");  // give me a different spot in the heap for my new string
		
		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {  //  == compares the stack values
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;  
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}
		
		String animal =  "anteaters";
		String animal2 = "antelope";
		
		if (animal.compareTo(animal2) == 0) {
			System.out.println("They are equal");
		}
		if (animal.compareTo(animal2) > 0) {
			System.out.println("animal is 'larger' than animal2");
		} else {
			System.out.println("animal2 is 'larger' than animal");
		}

	}
}

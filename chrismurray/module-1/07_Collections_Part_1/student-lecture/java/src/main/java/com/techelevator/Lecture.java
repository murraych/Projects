package com.techelevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List <String> names = new ArrayList<>();
		
		names.add("Sam");  // Sam is addded into the 0th index of the names list
		names.add("Joe"); // Joe goes into index 1
		names.add("Jim");  // Jim goes into index 2
		names.add("Tom");  //Tom goes into index 3
		
		System.out.println(names);	//actually calls a method called toString() which prints out all elements
		
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(i + ") " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		names.add("Sam"); 
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(i + ") " + names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		names.add(2, "Abe"); // This says put abe in index 2 and move everyone else down
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(i + ") " + names.get(i));
		}

		
		System.out.println("####################");
		System.out.println("Using Set to Replace an element in specific spot");
		System.out.println("####################");
		
		names.set(2, "Joe");	// This will 'replace' abe with Joe
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(i + ") " + names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		names.remove(1);	// removes element in index 1
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(i + ") " + names.get(i));
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		boolean joeInList = names.contains("Joe");
		System.out.println("Joe is in the list of names: " + joeInList);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		
		String[] namesArray = names.toArray(new String[names.size()]);
		
		for(int i = 0; i < namesArray.length; i++) {
			System.out.println(namesArray[i]);
		}

		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		
		List <Integer> numbers = new ArrayList<>();
		
		numbers.add(42);
		numbers.add(77);
		numbers.add(27);
		numbers.add(12);
		numbers.add(36);
		numbers.add(11);
		
		numbers.remove((Integer)12);	// have to cast in order to remove the element containing the 12. This is because the .remove is looking to remove the 12th index
		
		System.out.println(numbers);
		
		Integer age = new Integer(29); // here we call a constructor that puts 29 as an Integer into the var age
		Integer hourOfDay = new Integer ("10"); // here we call constructor that converts string to an integer
		
		if (hourOfDay < age) {
			System.out.println("hour is less than age");
		}
		
		

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		List<Double> prices = new ArrayList<Double>();
		prices.add(12.99);
		prices.add(1.99);
		prices.add(3.99);
		prices.add(6.99);
		
		for(Double price: prices) { // foreach loop is a shorthand way to loop through all elements in the list. 
			System.out.println(price); // print out each prices
		}

		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		Queue <String> todoList = new LinkedList<String>();
		
		todoList.offer("Pick up laundry from floor"); // adds to the queue
		todoList.offer("Make bed");
		todoList.offer("Wash the dishes");
		todoList.offer("Sweeping up the dog hair");
		
		
		
		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		
		
		while (todoList.size() > 0) {
			String nextItem = todoList.poll(); //removes element fro the top of the queue
			System.out.println("Crossed off my list: " + nextItem);
		}
		System.out.println("###############");
		

		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		
		Stack <String> browserStack = new Stack <>();
		
		browserStack.push("www.google.com"); // adds element to top of stack
		browserStack.push("www.cnn.com"); //adds element to top of stack
		browserStack.push("www.amazon.com");
		browserStack.push("www.google.com");
		browserStack.push("www.techelevator.com");
		
		////////////////////
		// POPPING THE STACK
		////////////////////
		
		while (browserStack.size() > 0) {
			String previousPage = browserStack.pop(); // removes element from top of stack -- index 0
			System.out.println("Previous page: " + previousPage);
		}

	}
}

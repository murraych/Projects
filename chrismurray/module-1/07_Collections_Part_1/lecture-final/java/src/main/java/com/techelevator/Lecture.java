package com.techelevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List <String> names = new ArrayList<>();
		
		names.add("Sam");  // Sam is added into the 0th index of the names List
		names.add("Joe");  // Joe => index 1
		names.add("Jim");  // Jim => index 2
		names.add("Tom");  // Tom => index 3
		
		System.out.println(names);  // actually calls a method called toString() which prints out all elements

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
		
		names.add(2, "Abe");  // this says put Abe in index 2 and move everyone else down
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(i + ") " + names.get(i));
		}
		
		System.out.println("*************************");
		System.out.println(" Using Set to replace an element in a specific location");
		System.out.println("*************************");
		names.set(2, "Joe");  // this will 'replace' Abe with Joe
		
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(i + ") " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		names.remove(1);  // remove element in index 1
		
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
		
		for (int i = 0; i < namesArray.length; i++) {
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
		
		numbers.remove((Integer)12);  // have to cast in order to remove the element containing the 12
		
		//numbers.remove(11);  can't do this because the 'default' will be to remove at index 11
		
		System.out.println(numbers);

		Integer age = new Integer(29);  // here we call a constructor that puts 29 as an Integer into the var age
		Integer hourOfDay = new Integer ("10");  // here call constructor that converts String to Integer
		
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
		
		for(Double price: prices) {  // foreach loop is a shorthand way to loop through all element in the List
			System.out.println(price);  // print out each price
		}
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		Queue <String> todoList = new LinkedList<String>();
		
		todoList.offer("Pick up laundry from floor"); // adds to the Queue
		todoList.offer("Make bed");
		todoList.offer("Wash the dishes");
		todoList.offer("Sweeping up the dog hair");
		
		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////

		while (todoList.size() > 0) {
			String nextItem = todoList.poll();  // removes element from the top of the Queue
			System.out.println("Crossed off my list: " + nextItem);
		}
		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////

		Stack <String> browserStack = new Stack <>();
		
		browserStack.push("www.stackoverflow.com");  // adds element to top of Stack -- index 0  google
		browserStack.push("www.cnn.com");     // adds element to top of Stack -- index 0  cnn, google
		browserStack.push("www.amazon.com");  // amazon, cnn, google
		browserStack.push("www.google.com"); // google, amazon, cnn, google
		browserStack.push("www.techelevator.com");  // techelevator, google, amazon, cnn, google
		////////////////////
		// POPPING THE STACK
		////////////////////
		
		System.out.println(browserStack.search("www.stackoverflow.com"));
		System.out.println(browserStack.search("www.techelevator.com"));
		
		while (browserStack.size() > 0) {
			String previousPage = browserStack.pop();  // removes element from top of Stack -- index 0
			System.out.println("Previous page: " + previousPage);
		}

	}
}

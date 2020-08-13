package com.techelevator;

public class ArrayDemoApp {

	
		
	

	public static void main(String[] args) {
		
		String[] numberStrArray = {"1", "3", "67", "72", "2"};
		//[] means it is an array
		
		int[] intArray = new int[5]; // means create an array called intArray and the size will be 5
		double[] priceArray; //only creates the stack element, does not reserve memory in the heap
		 
		
		// to load data into intArray, can do it 1 element at a time
		intArray[0] = 56;
		intArray[3] = 42;
		
		for (int i = 0; i < numberStrArray.length; i++) { // .length is a property of an array because theres no parenthesis
			int number = Integer.parseInt(numberStrArray[i]);
			// Integer.parseInt -- Integer is a class and the ParseInt that converts method that converts a string to an integer
			int result = number * 76;
			System.out.println(number + " * 76 = " + result);
			
		}
	}

}

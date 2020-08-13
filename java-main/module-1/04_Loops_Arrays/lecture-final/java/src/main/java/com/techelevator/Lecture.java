package com.techelevator;

public class Lecture {

    /*
    1. Return the created array
    */
    public int[] returnArray() {
        int[] array = { 80, 8080, 443 };  // declare an array and initialize all in one
        return array;
    }

    /*
    2. Return the first element of the array
    */
    public int returnFirstElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers[0];
    }

    /*
    3. Return the last element of the array
    */
    public int returnLastElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers[2];
    }

    /*
    4. Return the first element of the array from the parameters
    */
    public int returnFirstElementOfParam(int[] passedInArray) {
        return passedInArray[0];
    }

    /*
    5. Return the last element of the array from the parameters
    */
    public int returnLastElementOfParam(int[] passedInArray) {
        return passedInArray[passedInArray.length - 1];
    }
    
    // main included to run arrayManipulation() method
    public static void main(String[] args) {
    	arrayManipulation();
    }
    
    public static void arrayManipulation() {  // static means we don't have to create an object
    	// declare an array that holds 5 integers
    	int[] myArray = new int[5];
    	myArray[0] = 7; 
    	myArray[1] = 42;
    	myArray[2] = 29;
    	myArray[3] = 3;
    	myArray[4] = 56; 
     	// print out the first, third and last elements
    	System.out.println(myArray[0]);
    	System.out.println(myArray[2]);
    	System.out.println(myArray[myArray.length - 1]);
    	System.out.println(myArray[0] + " " + myArray[2] + " " + myArray[4]);
    	// add 6 to the third element and print out its new value
    	myArray[2] = myArray[2] + 6; // myArray[2] += 6
    	
    	System.out.println(myArray[2]);
    	
    	System.out.println(myArray); //  prints out the hexidecimal value of where array is store in memory
    	
    	// swap the values in the first and last positions
    	int helper = myArray[0];  // helper = 7
    	myArray[0] = myArray[myArray.length - 1];  //myArray[0] = 56
    	myArray[myArray.length - 1] = helper; // myArray[4] = 7
    	
    	System.out.println("After swapping:");
    	for (int i = 0; i < myArray.length; i++) {  // this is a for loop
    		System.out.println(myArray[i]);
    	}
    	
    }

    /*
    6. Here, a variable is defined within a block. How can we get the value of that outside of the block in order to
       return it? There are a couple of different ways of doing this, what can you come up with?
    */
    public int returnVariableFromBlock(int number) {

    	int result;
        { // A new block with scoped variables

            result = number * 5;

        } // the result variable disappears here

        return result; // We want to return result here. How?
    }

    /*
    7. What will the variable result be at the end of the method? Change the number in the logic expression so that
       it returns true.
    */
    public boolean returnOperationInBlock() {
        int result = 5;  			

        {
            int multiplier = 10;
            result *= multiplier;  // result = result * multiplier
        }

        return result == 50; // <-- Change the number to match result and make this be true
    }

    /*
    8. Return the only variable that is in scope at the return statement.
    */
    public double returnInScopeVariable() {
        double one = 1.0;
        {
            double three = 3.0;
            one += three;
            {
                double four = 4.0;
                three = four - one;
                one++;
            }

            double five = 5.0;
            double eight = five + three;
        }

        return one;
    }

    /*
    9. How many times do we go through this loop? Change the number in the logic expression so that it returns true.
    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = { 3, 4, 2, 9 };

        int counter = 0; // Must be started outside the block so that have access to it after the block
        	//  1.				2.						4.
        for (int i = 0; i < arrayToLoopThrough.length; i++) {  // i = 4  counter = 4
        	// 3.
            counter++;
        }

        return counter == 4; // What should the number be to return true?
    }

    /*
    10. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCorrectCount() {
        int[] arrayToLoopThrough = { 4, 23, 9 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {  // i = 3  counter = 2
            counter += 1;
        }

        return counter == 3;
    }

    /*
    11. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCountCorrectTimes() {
        int[] arrayToLoopThrough = { 4, 23, 9, 4, 33 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter = counter + 1;
        }

        return counter == 5;
    }

    /*
    12. We want this loop to only count every other item starting at zero. What needs to change in the loop for
        it to do that?
    */
    public boolean returnSumEveryOtherNumber() {
        int[] arrayToLoopThrough = { 4, 3, 4, 1, 4, 6 };

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i = i + 2) {
            sum = sum + arrayToLoopThrough[i];
        }

        return sum == 12;
    }
}
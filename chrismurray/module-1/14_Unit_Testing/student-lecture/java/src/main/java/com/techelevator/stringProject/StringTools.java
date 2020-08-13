package com.techelevator.stringProject;

/**
 * Holds a String representation and provides some common operations
 *
 */
public class StringTools {
	
	private char[] value;
	private int length;
	
	/**
	 * creates a StringTools object with the given String
	 * @param input
	 */
	public StringTools(String input) {
		value = new char[1000];
		length = input.length();
		for(int i = 0; i < input.length(); i++) {
			value[i] = input.charAt(i);
		}
	}
	
	/**
	 * @return the length of the char[]
	 */
	public int length() {
		return length;
	}
	
	/**
	 * @param i is the index of the char to get.
	 * @return the char at the selected index.
	 */
	public char getCharAt(int i) {
		return value[i];
	}
}

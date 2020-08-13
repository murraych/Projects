/**
 * 
 */
package com.techelevator.debug_demo;


public class debugMe {

//	Start the program!
	public static void main(String[] args) {
			
//		Hello User!
		System.out.println(bannerMessage("Welcome!"));

	}
	
//	Accept a string and insert it in between to banner line
	public static String bannerMessage(String message){
		String banner = "************\n#\n************";
		banner.replace("#",message);
		return banner;
	}

}

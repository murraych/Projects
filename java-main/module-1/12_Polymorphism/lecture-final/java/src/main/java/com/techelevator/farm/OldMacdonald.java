package com.techelevator.farm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		List<Singable> singables = new ArrayList<>(Arrays.asList(new Cow(),
				new Dog(), new Sheep(), new Donkey(), new Tractor()));

		for (Singable sing : singables) {
			String name = sing.getName();
			String soundOnce = sing.getSound();
			String soundTwice = sing.getSoundTwice();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + soundTwice + " here");
			System.out.println("And a " + soundTwice +  " there");
			System.out.println("Here a " + soundOnce + " there a " + soundOnce + 
					" everywhere a " + soundTwice);
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println();
		}
		
		List<Sellable> sellables = new ArrayList<>(Arrays.asList(new Cow(),
				new Sheep(), new Donkey()));
		System.out.println("**************  Items for sale ***************");
		for (Sellable item: sellables) {
			System.out.println("Item to be sold: " + item.getName() );
								// setScale = 2 decimal places to the right of the point
			System.out.println("Price of item: " + item.getPrice().setScale(2));
		}
		
	}
	

}
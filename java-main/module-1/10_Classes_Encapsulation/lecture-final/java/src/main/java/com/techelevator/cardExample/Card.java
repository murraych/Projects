package com.techelevator.cardExample;

public class Card {

	private String suit;
	private int value;
	private boolean isFaceUp;
	private String color;
	private String faceValue;

	Card(String suit, int value) {  // provides the initial values for the data members
		isFaceUp = false;
		this.suit = suit;
		this.value = value;
		faceValue = "The " + value + " of " + suit;
	}

	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public boolean getIsFaceUp() {
		return isFaceUp;
	}

	public String getColor() {
		return color;
	}

	public String getFaceValue() {
		return faceValue;
	}

	public void turnOver() {
		isFaceUp = !isFaceUp;
	}
	
	public String toString() {
		return "Card [suit=" + suit + ", value=" + value + ", isFaceUp=" + isFaceUp + ", color=" + color
		+ ", faceValue=" + faceValue + "]";
		}
}

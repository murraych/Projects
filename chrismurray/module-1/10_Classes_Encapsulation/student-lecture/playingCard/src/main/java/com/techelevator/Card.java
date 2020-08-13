package com.techelevator;

public class Card {

		private String suit;
		private int value;
		private boolean isFaceUp;
		private String color;
		private String faceValue;
		
		public Card(String suit, int value) {
			this.suit = suit;
			this.value = value;
			this.isFaceUp = false;
			this.faceValue = this.value + " of " + this.suit;
			if (this.suit.equals("hearts") || this.suit.equals("daimonds")){
				this.color = "red";
			} else {
				this.color = "black";
			}
		}

		
		
	public boolean turnOver() {
		if (isFaceUp) {
			isFaceUp = false;
			return isFaceUp;
		} else {
			isFaceUp = true;
			return true;
		}
	}
		
		
		
		@Override
	public String toString() {
		return "Card [suit=" + suit + ", value=" + value + ", isFaceUp=" + isFaceUp + ", color=" + color
				+ ", faceValue=" + faceValue + "]";
	}



		public String getSuit() {
			return suit;
		}

		public int getValue() {
			return value;
		}

		public boolean getisFaceUp() {
			return isFaceUp;
		}

		public String getColor() {
			return color;
		}

		public String getFaceValue() {
			return faceValue;
		}
		
	
		
		
}

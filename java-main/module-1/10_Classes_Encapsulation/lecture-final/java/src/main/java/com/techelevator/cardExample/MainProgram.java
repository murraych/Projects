package com.techelevator.cardExample;

public class MainProgram {

	public static void main(String[] args) {
		Card aceOfSpades = new Card("s", 1);

		System.out.println(aceOfSpades);

		aceOfSpades.turnOver();

		System.out.println(aceOfSpades);

		Card twoOfHearts = new Card("h", 2);
		twoOfHearts.turnOver();
		System.out.println(twoOfHearts);

		Deck deckOfCards = new Deck();

		System.out.println(deckOfCards);

		deckOfCards.shuffle();

		System.out.println(deckOfCards);

		Card topCard = deckOfCards.deal();
		topCard.turnOver();

		System.out.println(topCard);

		System.out.println(deckOfCards);
	}

}

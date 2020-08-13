package com.techelevator.cardExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> listOfCards = new ArrayList<>();  // composition
	  // created a list that holds 52 cards

	public Deck() {
		for (String suit : new String[] { "c", "s", "d", "h" }) {
			for (int rank : new int[] { 1,2,3,4,5,6,7,8,9,10,11,12,13 }) {
				Card currentCard = new Card(suit, rank);
				listOfCards.add(currentCard);
			}
		}
	}

	/**
	 * Shuffles the deck of cards randomly. Uses the Collections.shuffle static method.
	 */
	public void shuffle() {
		Collections.shuffle(listOfCards);
	}

	/**
	 * Deals a card from the deck.
	 * @return the top card from the deck
	 */
	public Card deal() {
		if (size() != 0) {
			return listOfCards.remove(0);
		} else {
			return null;
		}
	}

	// Delegation method
	public int size() {
		return listOfCards.size();
	}

	private void flip() {
		for (Card playingCard : listOfCards) {
			playingCard.turnOver();
		}
	}

	@Override
	public String toString() {
		this.flip();
		String myselfAsString = "Deck [listOfCards=" + listOfCards + "]";
		this.flip();
		return myselfAsString;
	}

}

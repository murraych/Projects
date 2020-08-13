package com.techelevator;

public class FruitTree {

//Attributes
	private String typeOfFruit;
	private int piecesOfFruitLeft;

	
	
	
//GETTERS AND SETTERS
public String getTypeOfFruit() {
		return typeOfFruit;
	}
public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}

//METHODS
	public boolean pickFruit (int numberOfPiecesToRemove) {
		if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
			piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
			return true;
		} else {
			return false;
		}
	}

//CONSTRUCTOR
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		this.piecesOfFruitLeft = startingPiecesOfFruit;
	}

}

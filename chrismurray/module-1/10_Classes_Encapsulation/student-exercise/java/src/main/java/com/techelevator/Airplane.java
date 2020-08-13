package com.techelevator;

public class Airplane {

//ATTRIBUTES
	private String planeNumber;
	private int bookedFirstClassSeats;
	private int totalFirstClassSeats;
	private int bookedCoachSeats;
	private int totalCoachSeats;
	
//Derived
	public int getAvailableFirstClassSeats() {
		return totalFirstClassSeats - bookedFirstClassSeats;
	}
	
//GETTERS AND SETTERS
	public int getAvailableCoachSeats() {
		return totalCoachSeats - bookedCoachSeats;
	}

	public String getPlaneNumber() {
		return planeNumber;
	}

	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}

	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}

	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}

	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}

//METHODS
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if (forFirstClass && (totalFirstClassSeats >= totalNumberOfSeats)) {
			bookedFirstClassSeats += totalNumberOfSeats;
			return true;
		}
		else if ((!forFirstClass) && (totalCoachSeats >= totalNumberOfSeats)) {
			bookedCoachSeats += totalNumberOfSeats;
			return true;
		} return false;
	}
	
//CONSTRUCTORS
	
	public Airplane (String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
	}
	

	
	
	
}

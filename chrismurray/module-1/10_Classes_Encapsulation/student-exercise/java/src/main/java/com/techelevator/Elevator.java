package com.techelevator;

public class Elevator {

//Variables
	private int currentFloor = 1;
	private int numberOfFloors;
	private boolean doorOpen;

//Constructor
	public Elevator(int totalNumberOfFloors) {
		numberOfFloors = totalNumberOfFloors;
	}

//Methods
	public void openDoor() {
		doorOpen = true;
	}

	public void closeDoor() {
		doorOpen = false;
	}

	
	public void goUp(int desiredFloor) {
		if (!doorOpen && currentFloor < numberOfFloors) {
			currentFloor = desiredFloor;
		}
	}
	
	
//		public void goUp(int desiredFloor) {    ****why dont i work?*********
//		if (doorOpen = false) {
//			if (desiredFloor >= numberOfFloors) {
//				currentFloor = numberOfFloors;
//			} else {
//				currentFloor = desiredFloor;
//			}
//		}
//	}
	
//	public void goDown(int desiredFloor) {  
//		if (doorOpen = false) {
//			if (desiredFloor <= 1) {
//				currentFloor = 1;
//			} else {
//				currentFloor = desiredFloor;
//			}
//		}
//	}
	
	
	public void goDown(int desiredFloor) {
		if (!doorOpen && currentFloor > 1) {
			currentFloor = desiredFloor;
		}
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}
	
	
}
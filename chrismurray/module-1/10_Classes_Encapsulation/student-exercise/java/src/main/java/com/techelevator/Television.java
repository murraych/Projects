package com.techelevator;

public class Television {

//Attributes

	private boolean isOn = false;
	private int currentChannel = 3;
	private int currentVolume = 2;

//GETTERS AND SETTERS

	public boolean isOn() {
		return isOn;
	}

	public int getCurrentChannel() {
		return currentChannel;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

// CONSTRUCTORS	no need, default
	
	
// METHODS
	
	public void turnOff() {
		isOn = false;
	}
	
	public void turnOn() {
			isOn = true;
			currentChannel = 3;
			currentVolume = 2;
			
		}


	public void changeChannel (int newChannel)	{
		if (isOn && newChannel < 19 && newChannel > 2) {
			currentChannel = newChannel;
		}
	}
	
	public void channelUp() {
	if (isOn) {
		if(currentChannel < 18) {
			currentChannel = currentChannel + 1;
		}
		else { currentChannel = 3;
	}
		}
	
	}
	
	public void channelDown() {
	if (isOn) {
		if (currentChannel <=3) {
			currentChannel = 18;
		}
		else {
			currentChannel = currentChannel -1;
		}
	}
	}
	
	public void raiseVolume() {
	if (isOn) {
		if (currentVolume < 10) {
			currentVolume = currentVolume + 1;
		} else { currentVolume = 10;
	}	
	}
	}
	public void lowerVolume() {
	if (isOn) {
		if (currentVolume > 0) {
			currentVolume = currentVolume - 1;
		} else currentVolume = 0;
	}
	
	}
	
}

package com.techelevator.calculator;

public class Calculator {

private int result = 0;


public int add(int addend) {
	return result = result + addend;
}

public int getResult() {
	return result;
}

public int multiply(int multiplier) {
	return result = result * multiplier;
}


public int power(int exponent) {
	return result = (int)Math.pow(result, exponent);
}

public void reset() {
	result = 0;
}

public int subtract(int subtrahend) {
	return result = result - subtrahend;
}



}

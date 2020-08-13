package com.techelevator;

public class HomeworkAssignment {

	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;

	
	public String getLetterGrade() {
		double letterGrade = (double)earnedMarks / possibleMarks;
		if (letterGrade >= .90) {
			return "A";
		}
		else if (letterGrade < .90 && letterGrade >.79) {
			return "B";
		}
		else if (letterGrade < .80 && letterGrade > .69) {
			return "C";
		}
		else if (letterGrade < .70 && letterGrade > .59) {
			return "D";
		}
		else {
			return "F";
		}
	}
	
	public HomeworkAssignment (int possibleMarks) { // this is the constructor
		this.possibleMarks = possibleMarks;
	}
	
	
	public int getEarnedMarks() {
		return earnedMarks;
	}
	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	
	
	
	
	
	
	
	
	
}

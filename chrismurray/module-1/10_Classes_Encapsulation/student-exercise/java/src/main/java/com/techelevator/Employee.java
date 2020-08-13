package com.techelevator;

public class Employee {

//DATA MEMBERS
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String department;
	private double annualSalary;

//DERIVED ATTRIBUTE	

	public String getFullName() {
		return lastName + ", " + firstName;
	}
	
// GETTERS AND SETTERS

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public double getAnnualSalary() {
		return annualSalary;
	}

//METHOD
	
	public void raiseSalary (double percent) {
		annualSalary = (annualSalary * (percent/100)) + annualSalary;
	}

//CONSTRUCTOR
	public Employee (int employeeId, String firstName, String lastName, double salary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		annualSalary = salary;
	}
	
}

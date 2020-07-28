package com.techelevator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Park {

//Data Members

	private Long parkId;
	private String name;
	private String location;
	private LocalDate establishDate;
	private int area;
	private int visitors;
	private String description;

//Constructors
	public Park(String name) {
		this.name = name;
	}

	public Park(String name, String location, LocalDate establishDate, int area, int visitors, String description) {
		this.name = name;
		this.location = location;
		this.establishDate = establishDate;
		this.area = area;
		this.visitors = visitors;
		this.description = description;
	}

	public Park(Long id, String name, String location, LocalDate establishDate, int area, int visitors,
			String description) {
		this.parkId = id;
		this.name = name;
		this.location = location;
		this.establishDate = establishDate;
		this.area = area;
		this.visitors = visitors;
		this.description = description;
	}

//Methods

//Getters and Setters

	public Long getPark_id() {
		return parkId;
	}

	public void setPark_id(Long park_id) {
		this.parkId = park_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getEstablish_date() {
		return establishDate;
	}

	public void setEstablish_date(LocalDate establish_date) {
		this.establishDate = establish_date;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getVisitors() {
		return visitors;
	}

	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
	// Come back later and make it pretty
	public String getParkDetails() {
		// We looked up how to wrap a String. Looks like it needs a package that needs to 
		// be installed. WordUtils.wrap(String text, int wrapLength) 
		String areaFormatted = NumberFormat.getNumberInstance(Locale.US).format(this.getArea());
		String visitorsFormatted = NumberFormat.getNumberInstance(Locale.US).format(this.getVisitors());
		String info = String.format("%s\n%-20s%s\n%-20s%s\n%-20s%s sq km\n%-20s%s\n\n%s", 
			this.getName(), "Location:", this.getLocation(), "Established:", this.getEstablish_date().toString(),
			"Area:", areaFormatted, 
			"Annual Visitors:", visitorsFormatted, 
			this.getDescription());
		return info;
	}

	public boolean equals(Park toCompare) {
		return ((this.parkId == toCompare.getPark_id()) && (this.name.equalsIgnoreCase(toCompare.getName())) 
				&& (this.location.equalsIgnoreCase(toCompare.getLocation())) && (this.establishDate.equals(toCompare.getEstablish_date()))
				&& this.area == toCompare.getArea() && this.visitors == toCompare.getVisitors()
				&& this.description.equalsIgnoreCase(toCompare.getDescription()));
	}
}

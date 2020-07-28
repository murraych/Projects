package com.techelevator;

import java.math.BigDecimal;
import java.time.Month;


public class Campground {
	
//Data Members
	private Long campgroundId;
	private Long parkId;
	private String name;
	private String openFromMm;
	private String openToMm;
	private BigDecimal dailyFee;
	

//Constructor
	
	public Campground(Long parkId, String name, String openFromMm, String openToMm, BigDecimal dailyFee) {
		this.parkId = parkId;
		this.name = name;
		this.openFromMm = openFromMm;
		this.openToMm = openToMm;
		this.dailyFee = dailyFee;
	}
	
	public Campground(Long campgroundId, Long parkId, String name, String openFromMm, String openToMm, BigDecimal dailyFee) {
		this.campgroundId = campgroundId;
		this.parkId = parkId;
		this.name = name;
		this.openFromMm = openFromMm;
		this.openToMm = openToMm;
		this.dailyFee = dailyFee;
	}
	
//Methods
	
	// TODO test getters and setters for 75% coverage later if time
	
//Getters and Setters
	public Long getcampgroundId() {
		return campgroundId;
	}
	public void setcampgroundId(Long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public Long getparkId() {
		return parkId;
	}
	public void setparkId(Long parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getopenFromMm() {
		return openFromMm;
	}
	public void setopenFromMm(String openFromMm) {
		this.openFromMm = openFromMm;
	}
	public String getopenToMm() {
		return openToMm;
	}
	public void setopenToMm(String openToMm) {
		this.openToMm = openToMm;
	}
	public BigDecimal getdailyFee() {
		return dailyFee;
	}
	public void setdailyFee(BigDecimal dailyFee) {
		this.dailyFee = dailyFee;
	}
	
	@Override
	public String toString() {
		String startMonth = Month.of(Integer.parseInt(this.getopenFromMm())).toString();
		startMonth = startMonth.substring(0, 1) + startMonth.substring(1).toLowerCase();
		String endMonth = Month.of(Integer.parseInt(this.getopenToMm())).toString();
		endMonth = endMonth.substring(0, 1) + endMonth.substring(1).toLowerCase();
		String info = String.format("%-30s%-15s%-15s$%.2f", 
			this.getName(), startMonth, endMonth, this.getdailyFee());
		

		return info;
	}
	

	public boolean equals(Campground toCompare) {
		return ((this.campgroundId == toCompare.getcampgroundId()) 
				&& this.parkId == toCompare.getparkId()
				&& (this.name.equalsIgnoreCase(toCompare.getName()))
				&& (this.openFromMm.equals(toCompare.getopenFromMm()))
				&& this.openToMm.equals(toCompare.getopenToMm())
				&& this.dailyFee.equals(toCompare.getdailyFee()));
	}


}

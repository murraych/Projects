package com.techelevator;

import java.time.LocalDate;

public class Reservation {

	// Data members
	private long reservationId;
	private long siteId;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate reserveDate;
	
	// CTORs
	/*
	 * Generic constructor with default values for reserver name set to "Unknown Party" and reservation creation date set to today
	 */
	public Reservation() {
		this.name = "Unknown Party";
		this.reserveDate = LocalDate.now();
	}
	
	/*
	 * Detailed constructor
	 * 
	 * @param siteID the ID number of the site to be reserved
	 * @param name the reserver's name
	 * @param start date when the reservation begins
	 * @param end date when the reservation ends
	 * @param reserved date when the reservation is created
	 */
	public Reservation(long siteID, String name, LocalDate start, LocalDate end, LocalDate reserved) {
		this.siteId = siteID;
		this.name = name;
		this.startDate = start;
		this.endDate = end;
		this.reserveDate = reserved;
	}
	
	/*
	 * Detailed constructor
	 * 
	 * @param reserveID the reservation or confirmation number
	 * @param siteID the ID number of the site to be reserved
	 * @param name the reserver's name
	 * @param start date when the reservation begins
	 * @param end date when the reservation ends
	 * @param reserved date when the reservation is created
	 */
	public Reservation(long reserveID, long siteID, String name, LocalDate start, LocalDate end, LocalDate reserved) {
		this.reservationId = reserveID;
		this.siteId = siteID;
		this.name = name;
		this.startDate = start;
		this.endDate = end;
		this.reserveDate = reserved;
	}

	// Getters and Setters
	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationID) {
		this.reservationId = reservationID;
	}

	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteID) {
		this.siteId = siteID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
	}
	
	@Override
	public String toString() {
		String info = String.format("%-12s%-10s%-35s%-15s%-15s%-15s", this.getReservationId(), this.getSiteId(), this.getName(), 
				this.getStartDate(), this.getEndDate(), this.getReserveDate());
		
		return info;
	}
	
	public boolean equals(Reservation toCompare) {
		return ((this.reservationId == toCompare.getReservationId()) && (this.siteId == toCompare.getSiteId()) && (this.name.equalsIgnoreCase(toCompare.getName())) &&
				(this.startDate.equals(toCompare.getStartDate())) && (this.endDate.equals(toCompare.getEndDate())) && (this.reserveDate.equals(toCompare.getReserveDate())));
		
		
	}
	
	
}

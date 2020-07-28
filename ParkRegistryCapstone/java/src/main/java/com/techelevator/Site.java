package com.techelevator;

import java.math.BigDecimal;

public class Site {
	
	// Data members
	private long siteId;
	private long campgroundId;
	private int siteNumber;
	private int maxOccupancy;
	private boolean isAccessible;
	private int maxRVLength;
	private boolean hasUtilities;
	private BigDecimal totalCost;
	private static final String COST_PLACEHOLDER = "XX";
	
	// CTORs
	/**
	 * Default constructor with default values for everything except the ID numbers
	 */
	public Site() {
		this.siteNumber = 0;
		this.maxOccupancy = 1;
		this.isAccessible = false;
		this.maxRVLength = 0;
		this.hasUtilities = false;
	}
	
	/**
	 * Detailed constructor for Site objects
	 * 
	 * @param siteID the ID number of the site
	 * @param campID the ID number of the campground to which the site belongs
	 * @param number the informal number given to the site
	 * @param maxPeople denoting maximum occupancy of the site
	 * @param isAccessible whether the site is wheel chair accessible
	 * @param maxLength maximum RV length supported by the site (0 > N/A)
	 * @param hasUtilities whether the site has services like toilets, shower, and waste collection
	 */
	public Site(long siteID, long campID, int number, int maxPeople, boolean isAccessible, int maxLength, boolean hasUtilities) {
		this.siteId = siteID;
		this.campgroundId = campID;
		this.siteNumber = number;
		this.maxOccupancy = maxPeople;
		this.isAccessible = isAccessible;
		this.maxRVLength = maxLength;
		this.hasUtilities = hasUtilities;
	}
	
	public Site(long campID, int number, int maxPeople, boolean isAccessible, int maxLength, boolean hasUtilities) {
		this.campgroundId = campID;
		this.siteNumber = number;
		this.maxOccupancy = maxPeople;
		this.isAccessible = isAccessible;
		this.maxRVLength = maxLength;
		this.hasUtilities = hasUtilities;
	}

	// Getters & Setters
	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteID) {
		this.siteId = siteID;
	}

	public long getCampgroundId() {
		return campgroundId;
	}

	// TODO test setters for 75% coverage if time
	
	public void setCampgroundId(long campgroundID) {
		this.campgroundId = campgroundID;
	}

	public int getSiteNumber() {
		return siteNumber;
	}

	public void setSiteNumber(int siteNumber) {
		this.siteNumber = siteNumber;
	}

	public int getMaxOccupancy() {
		return maxOccupancy;
	}

	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}

	public boolean isAccessible() {
		return isAccessible;
	}

	public void setAccessible(boolean isAccessible) {
		this.isAccessible = isAccessible;
	}

	public int getMaxRVLength() {
		return maxRVLength;
	}

	public void setMaxRVLength(int maxRVLength) {
		this.maxRVLength = maxRVLength;
	}

	public boolean getHasUtilities() {
		return hasUtilities;
	}

	public void setHasUtilities(boolean hasUtilities) {
		this.hasUtilities = hasUtilities;
	}
		
	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * Prints only the Site No. | Max Occup. | Accessible? | Max RV Length | Utility
	 * Does NOT print the Cost column - add on when making Menu printout?
	 * 
	 * @Returns Campground as nicely formatted String
	 */
	public String toString() {
		String access = (this.isAccessible()) ? "Yes" : "No";
		String maxRV = (this.maxRVLength == 0) ? "N/A" : "" + this.maxRVLength;
		String utility = (this.hasUtilities) ? "Yes" : "N/A";
		String cost = (totalCost == null) ? COST_PLACEHOLDER : "$" + totalCost.setScale(2, BigDecimal.ROUND_HALF_UP);
		String info = String.format("%-10s%-10s%-20s%-20s%-10s%s", 
				this.getSiteNumber(),
				this.getMaxOccupancy(),
				access,
				maxRV,
				utility,
				cost);
		
		return info;
	}
	
	// We're ignoring site number because that might change - i.e. the sign 
	// could have fallen off / got eaten etc and then replaced - Ask Rich/Margaret?
	//It ws confirmed that we need site number was added already below
	public boolean equals(Site toCompare) {
		return (this.siteId == toCompare.getSiteId()
				&& this.siteNumber == toCompare.getSiteNumber()
				&& this.campgroundId == toCompare.getCampgroundId()
				&& this.maxOccupancy == toCompare.getMaxOccupancy()
				&& this.isAccessible == toCompare.isAccessible()
				&& this.maxRVLength == toCompare.getMaxRVLength())
				&& this.hasUtilities == toCompare.getHasUtilities();
				
	}
}

package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SiteDAO {

	/**
	 * removed abstract
	 */
	public List<Site> getAllSitesByCampground(long campgroundId);
	
	/**
	 * Takes daily fee specific to a campground and multiplies it by the number of days reserving
	 * 
	 * @param siteId
	 * @param startDate
	 * @param endDate
	 * @return BigDecimal total cost amount
	 */
	BigDecimal calculateTotalCost(long campgroundId, LocalDate startDate, LocalDate endDate);
}

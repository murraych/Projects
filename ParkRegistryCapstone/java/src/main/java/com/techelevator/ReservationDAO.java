package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO {

	/**
	 * Create a new reservation and save it to the database and set reservation ID based on database assignment
	 * 
	 * @param notYetSaved takes in Reservation object to be saved
	 */
	public String createReservation(Reservation notYetSaved);
	
	/**
	 * Search all saved reservations by person name
	 * 
	 * @param name is the person who made the original reservation
	 * @return List of reservations made by that person
	 */
	public List<Reservation> searchReservationsByName(String name);
	
	/**
	 * Name is self-explanatory
	 * 
	 * @param siteId is ID number of camp site
	 * @return List of all reservations made for the specific site
	 */
	public List<Reservation> getAllReservationsBySite(long siteId);
	
	/**
	 * Reservations by campground
	 * 
	 * @param campgroundId
	 * @return List of all reservations made for this specific campground, which may have multiple sites
	 */
//	public List<Reservation> getAllReservationsByCampground(long campgroundId);
	
	/**
	 * Reservations by Park
	 * 
	 * @param parkId
	 * @return List of all reservations made in this park, which has multiple campgrounds
	 */
	public List<Reservation> getAllReservationsByPark(long parkId);
	
//	/**
//	 * Takes daily fee specific to a campground and multiplies it by the number of days reserving
//	 * 
//	 * @param siteId
//	 * @param startDate
//	 * @param endDate
//	 * @return BigDecimal total cost amount
//	 */
//	BigDecimal calculateTotalCost(long siteId, LocalDate startDate, LocalDate endDate);
	
	/**
	 * Takes confirmation number and returns info about reservation
	 * 
	 * @param reservationId
	 * @return Name of reserver, Site ID, start date, end date, reservation date
	 */
	public Reservation searchByReservationId(long reservationId);
	
	public List<Reservation> checkAvailable(LocalDate start, LocalDate end, Campground campground);
	
}

package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSiteDAO implements SiteDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Site> getAllSitesByCampground(long campgroundId) {
		List<Site> sites= new ArrayList<>();
		String sqlSite = "SELECT * FROM site WHERE campground_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSite, campgroundId);
		while (results.next()) {
			Site site = mapRowToSite(results);
			sites.add(site);
		}
		
		return sites;
	}
	
	@Override
	public BigDecimal calculateTotalCost(long campgroundId, LocalDate startDate, LocalDate endDate) {
		// Table site connects to table campground, which has the daily_fee column
		// THANK YOU, Chris!
		Period period = Period.between(startDate, endDate);
		int diff = period.getDays() + 1;
		BigDecimal daysReserved = new BigDecimal(diff);
		BigDecimal dailyFee = BigDecimal.ZERO;
		
		// Get the daily_fee
		String sqlGetDailyFee = "SELECT daily_fee FROM campground WHERE campground_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetDailyFee, campgroundId);
		if (result.next()) {
			dailyFee = result.getBigDecimal("daily_fee");
		}
		
		BigDecimal totalCost = daysReserved.multiply(dailyFee);
		return totalCost; // Remember the rounding later to make pretty
	}
	
	
//	public List<Site> getAvailableSites(LocalDate start, LocalDate end) {
//		List<Site> sites= new ArrayList<>();
//		String sqlSite = "SELECT * FROM site WHERE campground_id = ?";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSite);
//		while (results.next()) {
//			Site site = mapRowToSite(results);
//			sites.add(site);
//		
//		
//		
//		return null;
//	}
	
	
//	public boolean checkAvailable(LocalDate start, LocalDate end) {
//	List<Reservation> conflicts = new ArrayList<>();	
//	String sqlCheckStartDuring = "SELECT * FROM reservation WHERE from_date BETWEEN ? AND ?";
//	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCheckStartDuring, start, end);
//		while (results.next()) {
//			Reservation reservation = mapRowToReservation(results);
//			conflicts.add(reservation);
//		}
//		String sqlCheckEndDuring = "SELECT * FROM reservation WHERE to_date BETWEEN ? AND ?";
//		SqlRowSet results1 = jdbcTemplate.queryForRowSet(sqlCheckEndDuring, start, end);
//			while (results1.next()) {
//				Reservation reservation = mapRowToReservation(results1);
//				conflicts.add(reservation);
//			}
//		
//		String sqlIncluding = "SELECT * FROM reservation WHERE from_date < ? AND to_date > ?";
//		SqlRowSet results2 = jdbcTemplate.queryForRowSet(sqlIncluding, start, end);
//			while (results2.next()) {
//				Reservation reservation = mapRowToReservation(results2);
//				conflicts.add(reservation);
//			}
//		if (conflicts.size() > 0) {
//			return false;
//		} else return true;
//	}

	private Site mapRowToSite (SqlRowSet siteResults) {
		Site theSite = new Site(
				siteResults.getLong("site_id"),
				siteResults.getLong("campground_id"),
				siteResults.getInt("site_number"),
				siteResults.getInt("max_occupancy"), 
				siteResults.getBoolean("accessible"),
				siteResults.getInt("max_rv_length"),
				siteResults.getBoolean("utilities"));
		
		return theSite;
	}
}

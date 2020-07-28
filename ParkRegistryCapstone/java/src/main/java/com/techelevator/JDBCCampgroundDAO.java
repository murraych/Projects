package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCampgroundDAO implements CampgroundDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Campground> getAllCampgroundsByPark(Long parkId) {
		List<Campground> campgrounds = new ArrayList<>();
		String sqlCampground = "SELECT * FROM campground WHERE park_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCampground, parkId);
		while (results.next()) {
			Campground campground = mapRowToCampground(results);
			campgrounds.add(campground);
		}
		
		return campgrounds;
	}
	
//	public Campground checkCampgroundOpen(long campId, LocalDate start, LocalDate end) {
//		// If we wanted to do the BONUS for campground off-seasons
//		// If LocalDate.start.getMonth not between parkOpenmm and parkClosemm
//		String arrivalMonth = (start.getMonthValue() < 10) ? "0" + start.getMonthValue() : "" + start.getMonthValue();
//		String departureMonth = (end.getMonthValue() < 10) ? "0" + end.getMonthValue() : "" + end.getMonthValue();
//		Campground campground = null;
//		String sqlCheckCampMonths = "SELECT * FROM campground WHERE campground_id = ? AND "
//				+ "open_from_mm <= ? AND open_to_mm >= ?";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCheckCampMonths, campId, arrivalMonth,
//				departureMonth);
//		if (results.next()) {
//			campground = mapRowToCampground(results);
//		}
//		return campground;
//	}

	private Campground mapRowToCampground (SqlRowSet campgroundResults) {
		Campground theCampground = new Campground(
				campgroundResults.getLong("campground_id"),
				campgroundResults.getLong("park_id"),
				campgroundResults.getString("name"),
				campgroundResults.getString("open_from_mm"), 
				campgroundResults.getString("open_to_mm"),
				campgroundResults.getBigDecimal("daily_fee"));
				
		return theCampground;
	}
}

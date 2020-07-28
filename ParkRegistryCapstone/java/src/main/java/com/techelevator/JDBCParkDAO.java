package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> parks = new ArrayList<>();
		String sqlPark = "SELECT * FROM park";
		SqlRowSet parkResults = jdbcTemplate.queryForRowSet(sqlPark);
		while (parkResults.next()) {
			Park park = mapRowToPark(parkResults);
			parks.add(park);
		}
		return parks;
	}

	private Park mapRowToPark(SqlRowSet parkResults) {
		Park thePark = new Park(parkResults.getLong("park_id"), parkResults.getString("name"),
				parkResults.getString("location"), parkResults.getDate("establish_date").toLocalDate(),
				parkResults.getInt("area"), parkResults.getInt("visitors"), parkResults.getString("description"));

		return thePark;

	}
}

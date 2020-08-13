package com.techelevator.community;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class CommunityJdbcDao implements CommunityDao {

	private JdbcTemplate jdbcTemplate;

	public CommunityJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// To insert a date into a prepared statement, wrap the date in
	// `Date.valueOf()`
	// method: `Date.valueOf(myObject.getCreated())`

	@Override
	public void save(Community newCommunity) {
		// Implement this method to save communities to database
	}

	@Override
	public List<Community> getAllCommunities() {
		// Implement this method to pull in all communities from database

		return null;
	}

	private Community mapRowToCommunity(SqlRowSet results) {
		Community communityRow = new Community();
		communityRow.setId(results.getLong("id"));
		communityRow.setName(results.getString("name"));
		communityRow.setLatitude(results.getBigDecimal("latitude"));
		communityRow.setLongitude(results.getBigDecimal("longitude"));
		communityRow.setCreated(results.getDate("created").toLocalDate());
		communityRow.setLive(results.getBoolean("live"));
		return communityRow;
	}

}

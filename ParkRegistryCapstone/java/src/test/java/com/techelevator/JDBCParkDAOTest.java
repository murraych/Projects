package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAOTest extends DAOIntegrationTest {
	
	private static final String TESTPARK = "Test Park";
	private JDBCParkDAO dao;
	private Park testPark;
//	private static SingleConnectionDataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	List<Park> results;

	@BeforeClass
	public static void setupBeforeClass() throws Exception {
//		dataSource = new SingleConnectionDataSource();
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("postgres1");
//		dataSource.setAutoCommit(false);
		setupDataSource();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		dataSource.destroy();
		closeDataSource();
	}

	@Before
	public void setUp() throws Exception {
		testPark = new Park((long)17, TESTPARK, "Michigan", LocalDate.now(), 400, 14, "Lovely test park for family and friends.");
		jdbcTemplate = new JdbcTemplate(getDataSource());
		dao = new JDBCParkDAO(getDataSource());
		results = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
//		dataSource.getConnection().rollback();
		rollback();
	}

	@Test
	public void get_all_parks_test() {
		String sqlGetAllParks = "SELECT COUNT(*) AS count FROM park";
		SqlRowSet parkResults = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		int parkCount = 0;
		if (parkResults.next()) {
			parkCount = parkResults.getInt("count");
		}
		results = dao.getAllParks();
		assertEquals(parkCount, results.size());
		
	}

}

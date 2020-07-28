package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSiteDAOTest extends DAOIntegrationTest {

	private JdbcTemplate jdbcTemplate;
	private JDBCSiteDAO dao;
	private Park testPark;
	private Campground testCampground;
	private Site testSite;
	private static final String TEST_CAMPGROUND = "Test Campground";
	private static final String TEST_PARK = "Test Park";
	private static final LocalDate START = LocalDate.of(2020, 05, 16);
	private static final LocalDate END = LocalDate.of(2020, 05, 23);
	private List<Site> results;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setupDataSource();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		closeDataSource();
	}

	@Before
	public void setUp() throws Exception {
		// Initialize basic data members
		testPark = new Park(TEST_PARK, "Michigan", LocalDate.now(), 400, 14,
				"Lovely test park for family and friends.");
		jdbcTemplate = new JdbcTemplate(getDataSource());
		dao = new JDBCSiteDAO(getDataSource());
		results = new ArrayList<>();

		// Inserting test park into database
		String sqlInsertTestPark = "INSERT INTO park (name, location, establish_date, area,"
				+ " visitors, description) VALUES (?, ?, ?, ?, ?, ?) RETURNING park_id";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlInsertTestPark, testPark.getName(), testPark.getLocation(),
				testPark.getEstablish_date(), testPark.getArea(), testPark.getVisitors(), testPark.getDescription());
		if (result.next()) {
			testPark.setPark_id(result.getLong("park_id"));
		}

		// inserting campground into database
		testCampground = new Campground(testPark.getPark_id(), TEST_CAMPGROUND, "05", "09", BigDecimal.TEN);
		String sqlInsertTestCampground = "INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee)"
				+ "VALUES (?, ?, ?, ?, ?) RETURNING campground_id";
		SqlRowSet campResult = jdbcTemplate.queryForRowSet(sqlInsertTestCampground, testPark.getPark_id(),
				testCampground.getName(), testCampground.getopenFromMm(), testCampground.getopenToMm(),
				testCampground.getdailyFee());
		if (campResult.next()) {
			testCampground.setcampgroundId(campResult.getLong("campground_id"));
		}

		// inserting site into database
		testSite = new Site(testCampground.getcampgroundId(), 17, 5, true, 50, false);
		String sqlInsertTestSite = "INSERT INTO site (campground_id, site_number, max_occupancy, accessible,"
				+ "max_rv_length, utilities) VALUES (?, ?, ?, ?, ?, ?) RETURNING site_id";
		SqlRowSet siteResult = jdbcTemplate.queryForRowSet(sqlInsertTestSite, testCampground.getcampgroundId(),
				testSite.getSiteNumber(), testSite.getMaxOccupancy(), testSite.isAccessible(),
				testSite.getMaxRVLength(), testSite.getHasUtilities());
		if (siteResult.next()) {
			testSite.setSiteId(siteResult.getLong("site_id"));
		}
	}

	@After
	public void tearDown() throws Exception {
		rollback();
	}

	@Test
	public void return_dummy_site_from_dummy_campground() {
		results = dao.getAllSitesByCampground(testCampground.getcampgroundId());
		assertEquals(1, results.size());
	}
	
	@Test
	public void correct_total_camping_cost() {
		BigDecimal actualTotal = dao.calculateTotalCost(testCampground.getcampgroundId(), START, END);
		BigDecimal expectedTotal = new BigDecimal("80.0");
		assertEquals(expectedTotal, actualTotal);
	}

}

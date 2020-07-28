package com.techelevator;

import java.math.BigDecimal;
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
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCReservationDAOTest extends DAOIntegrationTest {

	private JdbcTemplate jdbcTemplate;
	private JDBCReservationDAO dao;
	private Park testPark;
	private Campground testCampground;
	private Site testSite;
	private Reservation testReservation;
	private static final String TEST_CAMPGROUND = "Test Campground";
	private static final String TEST_PARK = "Test Park";
	private static final String TEST_RESERVER = "Test Reserver";
	private static final LocalDate START = LocalDate.of(2020, 05, 16);
	private static final LocalDate END = LocalDate.of(2020, 05, 23);
	private List<Reservation> results;

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
		dao = new JDBCReservationDAO(getDataSource());
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
		
		// inserting reservation into database
		testReservation = new Reservation(testSite.getSiteId(), TEST_RESERVER, START,
				END, LocalDate.now());
		String sqlInsertTestReservation = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date)"
				+ "VALUES (?, ?, ?, ?, ?) RETURNING reservation_id";
		SqlRowSet reservationResult = jdbcTemplate.queryForRowSet(sqlInsertTestReservation, testSite.getSiteId(),
				testReservation.getName(), testReservation.getStartDate(), testReservation.getEndDate(),
				testReservation.getReserveDate());
		if (reservationResult.next()) {
			testReservation.setReservationId(reservationResult.getLong("reservation_id"));
		}
	}

	@After
	public void tearDown() throws Exception {
		rollback();
	}

	@Test
	public void create_reservation_test() {
		Reservation newReservation = new Reservation(testSite.getSiteId(), TEST_RESERVER, LocalDate.of(2020, 05, 16),
				LocalDate.of(2020, 05, 23), LocalDate.now());
		String sqlBeforeCreate = "SELECT COUNT(*) AS count FROM reservation WHERE site_id = ?";
		SqlRowSet beforeResults = jdbcTemplate.queryForRowSet(sqlBeforeCreate, testSite.getSiteId());
		int beforeCount = 0;
		if (beforeResults.next()) {
			beforeCount = beforeResults.getInt("count");
		}
		assertEquals(1, beforeCount);
		String result = dao.createReservation(newReservation);
		String sqlAfterCreate = "SELECT COUNT(*) AS count FROM reservation WHERE site_id = ?";
		SqlRowSet afterResults = jdbcTemplate.queryForRowSet(sqlAfterCreate, testSite.getSiteId());
		int afterCount = 0;
		if (afterResults.next()) {
			afterCount = afterResults.getInt("count");
		}
		assertEquals(2, afterCount);
		assertEquals("The reservation has been made and the confirmation id is " + newReservation.getReservationId(), result);
	}
	
	@Test
	public void search_reservation_by_existing_name_test() {
		results = dao.searchReservationsByName(TEST_RESERVER);
		assertNotNull(results);
		assertEquals(1, results.size());
	}
	
	@Test
	public void search_reservation_by_invalid_name() {
		results = dao.searchReservationsByName("Supercalifragilisticexpialadocious");
		assertEquals(0, results.size());
	}
	
	@Test
	public void get_reservation_by_site_test () {
		results = dao.getAllReservationsBySite(testSite.getSiteId());
		assertNotNull(results);
		assertEquals(1, results.size());
	}

	@Test
	public void get_all_reservations_by_park_test() {
		results = dao.getAllReservationsByPark(testPark.getPark_id());
		assertNotNull(results);
		assertEquals(1, results.size());
	}
	
	@Test
	public void get_all_reservations_by_site_test() {
		results = dao.getAllReservationsBySite(testSite.getSiteId());
		assertNotNull(results);
		assertEquals(1, results.size());
	}
	
	@Test
	public void invalid_reservation_id_returns_nothing() {
		int invalidId = -1;
		Reservation invalidReservation = dao.searchByReservationId(invalidId);
		assertNull(invalidReservation);
	}
	
	@Test
	public void valid_reservation_id_test() {
		long validId = testReservation.getReservationId();
		Reservation validResult = dao.searchByReservationId(validId);
		assertNotNull(validResult);
	}
	
	@Test
	public void conflicting_time_returns_false() {
		// Start during, end after
		assertNotEquals(0, (dao.checkAvailable(LocalDate.of(2020, 05, 22), LocalDate.of(2020, 05, 25), testCampground)).size());
		// Start during, end on same end date
		assertNotEquals(0, (dao.checkAvailable(LocalDate.of(2020, 05, 22), END, testCampground)).size());
		// Start during, end during
		assertNotEquals(0, (dao.checkAvailable(LocalDate.of(2020, 05, 20), LocalDate.of(2020, 05, 22), testCampground)).size());
		
		// Start before, end during
		assertNotEquals(0, (dao.checkAvailable(LocalDate.of(2020, 04, 30), LocalDate.of(2020, 05, 20), testCampground)).size());
		// Start before, end after
		assertNotEquals(0, (dao.checkAvailable(LocalDate.of(2020, 04, 30), LocalDate.of(2020, 07, 07), testCampground)).size());
		// Start before, end on same
		assertNotEquals(0, (dao.checkAvailable(LocalDate.of(2020, 04, 30), END, testCampground)).size());
		
		// Start on same start, end during
		assertNotEquals(0, (dao.checkAvailable(START, LocalDate.of(2020, 05, 20), testCampground)).size());
		// Start on same start, end on same end
		assertNotEquals(0, (dao.checkAvailable(START, END, testCampground)).size());
		// Start on same start, end after
		assertNotEquals(0, (dao.checkAvailable(START, LocalDate.of(2020, 06, 01), testCampground)).size());
	}
	
	@Test
	public void nonconflicting_time_returns_available() {
		// Start before, end before
		assertEquals(0, (dao.checkAvailable(LocalDate.of(2020, 01, 20), LocalDate.of(2020, 02, 20), testCampground)).size());
		
		// Start after, end after
		assertEquals(0, (dao.checkAvailable(LocalDate.of(2020, 11, 20), LocalDate.of(2020, 12, 20), testCampground)).size());
	}
	
}

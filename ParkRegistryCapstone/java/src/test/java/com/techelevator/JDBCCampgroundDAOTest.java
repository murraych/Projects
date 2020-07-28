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

public class JDBCCampgroundDAOTest extends DAOIntegrationTest {

	private static final String TEST_CAMPGROUND_1 = "Test Campground 1";
	private static final String TEST_CAMPGROUND_2 = "Test Campground 2";
	private static final String TEST_PARK = "Test Park 1";
	private JDBCCampgroundDAO dao;
	private Park testPark;
	private Campground testCampground1;
	private Campground testCampground2;
	private JdbcTemplate jdbcTemplate;
	List<Campground> results;

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
		testPark = new Park(TEST_PARK, "Michigan", LocalDate.now(), 400, 14,
				"Lovely test park for family and friends.");
		jdbcTemplate = new JdbcTemplate(getDataSource());
		dao = new JDBCCampgroundDAO(getDataSource());
		results = new ArrayList<>();

		// Put dummy park into database and set Java dummy park's id
		String sqlInsertTestPark = "INSERT INTO park (name, location, establish_date, area,"
				+ " visitors, description) VALUES (?, ?, ?, ?, ?, ?) RETURNING park_id";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlInsertTestPark, testPark.getName(), testPark.getLocation(),
				testPark.getEstablish_date(), testPark.getArea(), testPark.getVisitors(), testPark.getDescription());
		if (result.next()) {
			testPark.setPark_id(result.getLong("park_id"));
		}

		// Initialize dummy campgrounds
		testCampground1 = new Campground(testPark.getPark_id(), TEST_CAMPGROUND_1, "05", "09", BigDecimal.TEN);
		testCampground2 = new Campground(testPark.getPark_id(), TEST_CAMPGROUND_2, "05", "09", BigDecimal.ONE);

		// Adding Dummy Campground 1 into campground table
		String sqlInsertTestCampground = "INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee)"
				+ "VALUES (?, ?, ?, ?, ?) RETURNING campground_id";
		SqlRowSet campResult = jdbcTemplate.queryForRowSet(sqlInsertTestCampground, testPark.getPark_id(),
				testCampground1.getName(), testCampground1.getopenFromMm(), testCampground1.getopenToMm(),
				testCampground1.getdailyFee());
		if (campResult.next()) {
			testCampground1.setcampgroundId(campResult.getLong("campground_id"));
		}
	}

	@After
	public void tearDown() throws Exception {
		rollback();
	}

	@Test
	public void get_all_campgrounds_by_park_1_expected() {
		// Return a count of all campgrounds in dummy park
		String sqlGetAllCampgroundsByPark = "SELECT COUNT(*) AS count FROM campground WHERE park_id = ?";
		SqlRowSet campgroundResults = jdbcTemplate.queryForRowSet(sqlGetAllCampgroundsByPark, testPark.getPark_id());
		int campgroundCount = 0;
		if (campgroundResults.next()) {
			campgroundCount = campgroundResults.getInt("count");
		}
		results = dao.getAllCampgroundsByPark(testPark.getPark_id());

		assertNotNull(results);
		assertEquals(campgroundCount, results.size());
	}

	@Test
	public void get_all_campgrounds_by_park_multiple_expected() {
		// Adding Dummy Campground 2 into campground table
		String sqlInsertTestCampground = "INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee)"
				+ "VALUES (?, ?, ?, ?, ?) RETURNING campground_id";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlInsertTestCampground, testPark.getPark_id(),
				testCampground2.getName(), testCampground2.getopenFromMm(), testCampground2.getopenToMm(),
				testCampground2.getdailyFee());
		if (result.next()) {
			testCampground2.setcampgroundId(result.getLong("campground_id"));
		}

		// Return a count of all campgrounds in dummy park
		String sqlGetAllCampgroundsByPark = "SELECT COUNT(*) AS count FROM campground WHERE park_id = ?";
		SqlRowSet campgroundResults = jdbcTemplate.queryForRowSet(sqlGetAllCampgroundsByPark, testPark.getPark_id());
		int campgroundCount = 0;
		if (campgroundResults.next()) {
			campgroundCount = campgroundResults.getInt("count");
		}
		results = dao.getAllCampgroundsByPark(testPark.getPark_id());

		assertNotNull(results);
		assertEquals(campgroundCount, results.size());
	}
	
//	@Test
//	public void cannot_reserve_when_campground_closed() {
//		// Test something before May or after September
//		Campground checker = dao.checkCampgroundOpen(testCampground1.getcampgroundId(), 
//				LocalDate.of(2020, 04, 01), LocalDate.of(2020, 04, 05));
//		assertNull(checker);
//		
//		// Oof need to check if the years are different...
//		checker = dao.checkCampgroundOpen(testCampground1.getcampgroundId(), LocalDate.of(2020, 11, 01), 
//				LocalDate.of(2021, 01, 01));
//		assertNull(checker);
//	}
//	
//	@Test
//	public void can_reserve_when_campground_open() {
//		// In May
//		Campground checker = dao.checkCampgroundOpen(testCampground1.getcampgroundId(), 
//				LocalDate.of(2020, 05, 01), LocalDate.of(2020, 05, 05));
//		assertNotNull(checker);
//		
//		// In Sep
//		
//		// Inbetween
//	}

}

package com.techelevator.community;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommunityJdbcDaoTest {

	private static SingleConnectionDataSource dataSource;
	private CommunityJdbcDao dao;
	private JdbcTemplate template;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/assessment");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/*
		 * The following line disables autocommit for connections returned by
		 * this DataSource. This allows us to rollback any changes after each
		 * test
		 */
		dataSource.setAutoCommit(false);
	}

	/*
	 * After all tests have finished running, this method will close the
	 * DataSource
	 */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		dao = new CommunityJdbcDao(dataSource);
		template = new JdbcTemplate(dataSource);
	}

	/*
	 * After each test, we rollback any changes that were made to the database
	 * so that everything is clean for the next test
	 */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void testSaveNewCommunityAddsARow() throws SQLException {
		long beforeCount = getCountFromDatabase();
		Community savedCommunity = new Community("TESTNAME", BigDecimal.ZERO, BigDecimal.ONE,
				LocalDate.ofEpochDay(101), true);

		dao.save(savedCommunity);

		assertEquals(
				"It doesn't look like the community passed to save() was actually saved in the database.",
				beforeCount + 1, getCountFromDatabase());
	}

	@Test
	public void testAllCommunityDataSaved() throws SQLException {
		Community savedCommunity = new Community("TESTNAME", BigDecimal.ZERO,
				BigDecimal.ONE, LocalDate.ofEpochDay(101), true);

		dao.save(savedCommunity);

		SqlRowSet result = template.queryForRowSet(
				"select * from communities where id=(select max(id) from communities)");
		if (result.next()) {
			assertEquals("The name was not properly set in the Community on save()",
					savedCommunity.getName(), result.getString("name"));
			assertEquals("The latitude was not properly set in the Community on save()",
					savedCommunity.getLatitude(), result.getBigDecimal("latitude"));
			assertEquals("The longitude was not properly set in the Community on save()",
					savedCommunity.getLongitude(),
					result.getBigDecimal("longitude"));
			assertEquals("live was not properly set in the Community on save()",
					savedCommunity.isLive(), result.getBoolean("live"));
			assertEquals("created was not properly set in the Community on save()",
					savedCommunity.getCreated(),
					result.getDate("created").toLocalDate());
		}
	}

	@Test
	public void testGetAllCommunities() {
		List<Community> allCommunities = dao.getAllCommunities();

		assertEquals(
				"There should be 200 entries in the database, but I only got back "
						+ allCommunities.size(),
				200, allCommunities.size());
	}

	@Test
	public void testGetCommunityDetailsInAllCommunities() {
		template.update("DELETE FROM communities");

		dao.save(new Community("TESTNAME", BigDecimal.ZERO, BigDecimal.ZERO,
				LocalDate.ofEpochDay(101), true));
		dao.save(new Community("TESTNAME2", BigDecimal.ONE, BigDecimal.ONE,
				LocalDate.ofEpochDay(102), false));
		dao.save(new Community("TESTNAME3", BigDecimal.ONE, BigDecimal.ZERO,
				LocalDate.ofEpochDay(103), true));

		List<Community> allCommunities = dao.getAllCommunities();

		Community second = allCommunities.get(1);

		assertEquals(
				"The name was not properly set in the Community on getAllCommunities()",
				"TESTNAME2", second.getName());
		assertEquals(
				"The latitude was not properly set in the Community on getAllCommunities()",
				BigDecimal.ONE, second.getLatitude());
		assertEquals(
				"The longitude was not properly set in the Community on getAllCommunities()",
				BigDecimal.ONE, second.getLongitude());
		assertEquals(
				"live was not properly set in the Community on getAllCommunities()",
				false, second.isLive());
		assertEquals(
				"created was not properly set in the Community on getAllCommunities()",
				LocalDate.ofEpochDay(102), second.getCreated());
	}

	private long getCountFromDatabase() {
		return template.queryForObject("select count(*) from communities",
				Long.class);
	}
}

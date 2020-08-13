package com.techelevator.cart;

import static org.junit.Assert.assertEquals;
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
public class CartJdbcDaoTest {

	private static SingleConnectionDataSource dataSource;
	private CartJdbcDao dao;
	private JdbcTemplate template;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/assessment");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		dao = new CartJdbcDao(dataSource);
		template = new JdbcTemplate(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void testSaveNewCartAddsARow() throws SQLException {
		long beforeCount = getCountFromDatabase();
		Cart savedCart = new Cart("TESTNAME", "TESTCOOKIE", LocalDate.ofEpochDay(101));

		dao.save(savedCart);

		assertEquals("It doesn't look like the cart passed to save() was actually saved in the database.", beforeCount + 1, getCountFromDatabase());
	}

	@Test
	public void testAllCartDataSaved() throws SQLException {
		Cart savedCart = new Cart("TESTNAME", "TESTCOOKIE", LocalDate.ofEpochDay(101));

		dao.save(savedCart);

		SqlRowSet result = template.queryForRowSet("select * from carts where id=(select max(id) from carts)");
		if(result.next()) {
			assertEquals("The username was not properly set in the Cart on save()", savedCart.getUsername(), result.getString("username"));
			assertEquals("The cookie_value was not properly set in the Cart on save()", savedCart.getCookieValue(), result.getString("cookie_value"));
			assertEquals("created was not properly set in the Cart on save()", savedCart.getCreated(),result.getDate("created").toLocalDate());
		}
	}

	@Test
	public void testGetAllCarts() {
		List<Cart> allCarts = dao.getAllCarts();

		assertEquals("There should be 200 entries in the database, but I only got back " + allCarts.size(), 200, allCarts.size());
	}

	@Test
	public void testGetCartDetailsInAllCarts() {
		template.update("DELETE FROM carts");

		dao.save(new Cart("TESTNAME", "TESTCOOKIE", LocalDate.ofEpochDay(101)));
		dao.save(new Cart("TESTNAME2", "TESTCOOKIE2", LocalDate.ofEpochDay(102)));
		dao.save(new Cart("TESTNAME3", "TESTCOOKIE3", LocalDate.ofEpochDay(103)));

		List<Cart> allCarts = dao.getAllCarts();

		Cart second = allCarts.get(1);

		assertEquals("The username was not properly set in the Cart on getAllCarts()", "TESTNAME2", second.getUsername());
		assertEquals("The cookieValue was not properly set in the Cart on getAllCards()", "TESTCOOKIE2", second.getCookieValue());
		assertEquals("created was not properly set in the Cart on getAllCards()", LocalDate.ofEpochDay(102), second.getCreated());
	}

	private long getCountFromDatabase() {
		return template.queryForObject("select count(*) from carts", Long.class);
	}
}

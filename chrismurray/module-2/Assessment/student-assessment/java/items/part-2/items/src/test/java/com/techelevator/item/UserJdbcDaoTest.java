package com.techelevator.item;

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
public class UserJdbcDaoTest {

	private static SingleConnectionDataSource dataSource;
	private UserJdbcDao dao;
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
		dao = new UserJdbcDao(dataSource);
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
	public void testSaveNewUserAddsARow() throws SQLException {
		long beforeCount = getCountFromDatabase();
		User savedUser = new User("TESTFIRST", "TESTLAST", "TESTEMAIL", "TESTR",
				LocalDate.ofEpochDay(101));

		dao.save(savedUser);

		assertEquals(
				"It doesn't look like the user passed to save() was actually saved in the database.",
				beforeCount + 1, getCountFromDatabase());
	}

	@Test
	public void testAllUserDataSaved() throws SQLException {
		User savedUser = new User("TESTFIRST", "TESTLAST", "TESTEMAIL",
				"TESTR", LocalDate.ofEpochDay(101));

		dao.save(savedUser);

		SqlRowSet result = template.queryForRowSet(
				"select * from users where id=(select max(id) from users)");
		if (result.next()) {
			assertEquals("The first_name was not properly set in the User on save()",
					savedUser.getFirstName(), result.getString("first_name"));
			assertEquals(
					"The last_name was not properly set in the User on save()",
					savedUser.getLastName(), result.getString("last_name"));
			assertEquals(
					"The email was not properly set in the User on save()",
					savedUser.getEmail(), result.getString("email"));
			assertEquals(
					"The role was not properly set in the User on save()",
					savedUser.getRole(), result.getString("role"));
			assertEquals("created was not properly set in the Community on save()",
					savedUser.getCreated(),
					result.getDate("created").toLocalDate());
		}
	}

	@Test
	public void testGetAllUsers() {
		List<User> allUsers = dao.getAllUsers();

		assertEquals(
				"There should be 200 entries in the database, but I only got back "
						+ allUsers.size(),
				200, allUsers.size());
	}

	@Test
	public void testGetUserDetailsInAllUsers() {
		template.update("DELETE FROM users");

		dao.save(new User("TESTFIRST", "TESTLAST", "TESTEMAIL",
				"TESTR", LocalDate.ofEpochDay(101)));
		dao.save(new User("TESTFIRST1", "TESTLAST1", "TESTEMAIL1",
				"TESTR1", LocalDate.ofEpochDay(102)));
		dao.save(new User("TESTFIRST2", "TESTLAST2", "TESTEMAIL2",
				"TESTR2", LocalDate.ofEpochDay(103)));

		List<User> allUsers = dao.getAllUsers();

		User second = allUsers.get(1);

		assertEquals(
				"The firstName was not properly set in the User on getAllUsers()",
				"TESTFIRST1", second.getFirstName());
		assertEquals(
				"The lastName was not properly set in the User on getAllUsers()",
				"TESTLAST1", second.getLastName());
		assertEquals(
				"The email was not properly set in the User on getAllUsers()",
				"TESTEMAIL1", second.getEmail());
		assertEquals(
				"The role was not properly set in the User on getAllUsers()",
				"TESTR1", second.getRole());
		assertEquals(
				"created was not properly set in the User on getAllUsers()",
				LocalDate.ofEpochDay(102), second.getCreated());
	}

	private long getCountFromDatabase() {
		return template.queryForObject("select count(*) from users",
				Long.class);
	}
}

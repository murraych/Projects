/**
 * 
 */
package com.techelevator.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Beer;

public class BeerJdbcDAOTest extends DAOIntegrationTest {
	private BeerJdbcDAO beerDao;
	private BreweryDAO breweryDao;
	JdbcTemplate template;

	@Before
	public void setup() {
		DataSource dataSource = this.getDataSource();
		template = new JdbcTemplate(dataSource);
		beerDao = new BeerJdbcDAO(template);
		breweryDao = new BreweryJdbcDAO(template);
		// insert a dummy brewery
		String createTestBrewery = "INSERT INTO breweries(id, name) VALUES(100,'TEST')";
		template.update(createTestBrewery);
		// insert a dummy beer to dummy brewery
		String addAbeer = "INSERT INTO beers(id, name, brewery_id, beer_type) VALUES(1000, 'Greatest Beer', 100, 131)";
		template.update(addAbeer);
	}

	@Test
	public void getAllBeers() {
		String sqlCountAll = "SELECT COUNT(*) FROM beers";
		SqlRowSet result = template.queryForRowSet(sqlCountAll);
		result.next();
		List<Beer> listToTest = beerDao.getBeers();
		assertNotNull(listToTest);
		assertEquals(result.getInt(1), listToTest.size());
		System.out.println(result.getInt(1));
	}

	@Test
	public void getBeersByIdTest() {
		Beer actual = beerDao.getBeerById(100, 1000);
		System.out.println(actual.getName());
		assertEquals("Greatest Beer", actual.getName());
	}

	@Test
	public void deleteBeerTest() {
		assertEquals(9, beerDao.getBeers().size());
		beerDao.deleteBeer(1000);
		assertEquals(8, beerDao.getBeers().size());
	}
	
	@Test
	public void deleteBeersByBreweryId() {
		assertEquals(1, breweryDao.getBeersByBreweryId(100).size());
		beerDao.deleteBeersByBrewery(100);
		assertEquals(0, breweryDao.getBeersByBreweryId(100).size());
	}

}

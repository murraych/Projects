package com.techelevator.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

public class BreweryJdbcDaoTest extends DAOIntegrationTest {
	
	private BreweryJdbcDAO breweryDao;
	JdbcTemplate template;
	private BeerJdbcDAO beerDao;
	 @Before
	    public void setup() {
	        DataSource dataSource = this.getDataSource();
	        template = new JdbcTemplate(dataSource);
	        breweryDao = new BreweryJdbcDAO(template);
	        beerDao = new BeerJdbcDAO(template);
	        //insert a dummy brewery
	        String createTestBrewery = "INSERT INTO breweries(id, name) VALUES(100,'TEST')"; 
	        template.update(createTestBrewery);
	        //insert a dummy beer to dummy brewery
	        String addAbeer = "INSERT INTO beers(id, brewery_id, beer_type) VALUES(1000, 100, 131)";
	        template.update(addAbeer);
	        
	    }
	
	
	@Test
	public void getAllBreweriesTest() {
		String sqlTest = "SELECT COUNT(*) as count FROM breweries";
		SqlRowSet results = template.queryForRowSet(sqlTest);
		results.next();
		List<Brewery> testList = breweryDao.getAllBreweries();
		assertNotNull(testList);
		assertEquals(results.getInt(1), testList.size());
		//getInt(1) refers to the first column from left for our query
		// in this case it refers to count(*) column if we used getInt("count") that would work
	}
	
	@Test
	public void getBreweryByIdTest() {
		Brewery actual = breweryDao.getBreweryById(100);	
		assertNotNull(breweryDao.getBreweryById(100));
		assertEquals("TEST", actual.getName());
		System.out.println(breweryDao.getBreweryById(100));
	}
	
	@Test
	public void getBeersByBreweryIdTest() {
		String sqlTest = "SELECT COUNT(*) as count FROM beers WHERE brewery_id = ?";
		SqlRowSet results = template.queryForRowSet(sqlTest, 100);
		results.next();
		List<Beer> testList = breweryDao.getBeersByBreweryId(100);
		assertNotNull(testList);
		assertEquals(results.getInt(1), testList.size());
	}
	
	@Test
	public void getAllBreweriesWithGFBeerTest() {
		String sqlGetGfree = "SELECT COUNT(*) FROM breweries JOIN beers ON beers.brewery_id = breweries.id WHERE gluten_free = ?";
	    SqlRowSet result = template.queryForRowSet(sqlGetGfree, true);
	    result.next();
	    List<Brewery> testList = breweryDao.getAllBreweriesWithGFBeer();
	    assertNotNull(testList);
	    assertEquals(result.getInt(1), testList.size());
	}
	
	@Test
	public void deleteBreweryTest() {
		System.out.println(breweryDao.getAllBreweries().size());
		assertEquals(11, breweryDao.getAllBreweries().size());
		beerDao.deleteBeer(1000);
		breweryDao.deleteBrewery(100);
		System.out.println(breweryDao.getAllBreweries().size());
		assertEquals(10, breweryDao.getAllBreweries().size());
	}
	
//	@Test  <-- will try again later__Arif
//	public void createBreweryTest() { 
//		Brewery testBrew = new Brewery();
//		testBrew.setId(500);
//		testBrew.setName("TESTNAME");
//		testBrew.setAddress1("abc street");
//		breweryDao.createBrewery(testBrew);
//		
//		assertNotNull(testBrew);
//	}

}

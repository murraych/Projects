package com.techelevator.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.BeerType;

public class BeerTypeJdbcDAOTest extends DAOIntegrationTest{
	private BeerTypeJdbcDAO typeDao;
	private BeerJdbcDAO beerDao;
	private static int TEST_ID;
	private static String TEST_NAME;
	JdbcTemplate template;
	
	 @Before
	    public void setup() {
	        DataSource dataSource = this.getDataSource();
	        template = new JdbcTemplate(dataSource);
	        typeDao = new BeerTypeJdbcDAO(template);
	        beerDao = new BeerJdbcDAO(template);
	        //insert a dummy brewery
	        TEST_ID = 333;
	        TEST_NAME = "test beer type";
	        String sqlInsert = "INSERT INTO beer_type(id, name) VALUES(?, ?)";
	        template.update(sqlInsert, TEST_ID, TEST_NAME);
	       
	    }
	@Test
	public void listALlBeerTypesTest() {
		String sqlTest = "SELECT COUNT(*) FROM beer_type";
		SqlRowSet result = template.queryForRowSet(sqlTest);
		result.next();
		List<BeerType> actualList = typeDao.listAllBeerTypes();
		assertNotNull(actualList);
		assertEquals(result.getInt(1), actualList.size());
	}
	
	@Test
	public void deleteBeerTypeTest() {
		assertEquals(144, typeDao.listAllBeerTypes().size());
		typeDao.deleteBeerType(TEST_ID);
		assertEquals(143, typeDao.listAllBeerTypes().size());
	}

}

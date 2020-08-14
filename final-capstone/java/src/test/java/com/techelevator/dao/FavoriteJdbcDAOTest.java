package com.techelevator.dao;

import javax.sql.DataSource;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

public class FavoriteJdbcDAOTest extends DAOIntegrationTest {

	JdbcTemplate template;
	private FavoriteJdbcDAO favoriteDao;
	private BreweryJdbcDAO breweryDao;
	
	@Before
	public void setup() {
		DataSource dataSource = this.getDataSource();
		template = new JdbcTemplate(dataSource);
		favoriteDao = new FavoriteJdbcDAO(template);
		breweryDao = new BreweryJdbcDAO(template);
		//insert dummy favorite
		String createTestFavorite = "INSERT INTO favorite_breweries (user_id, brewery_id) VALUES (3,3)";
	}
	
	
}

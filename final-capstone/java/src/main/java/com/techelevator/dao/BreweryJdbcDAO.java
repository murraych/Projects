package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

@Component
public class BreweryJdbcDAO implements BreweryDAO {
	
	private JdbcTemplate template;
	public BreweryJdbcDAO(JdbcTemplate jdbcTemplate) {
		this.template = jdbcTemplate;
	}
	
	@Override
	public List<Brewery> getAllBreweries() {
		List<Brewery> breweryList = new ArrayList<>();	
		String sqlGetAllBrews = "SELECT * FROM breweries ORDER BY name";
		SqlRowSet results = template.queryForRowSet(sqlGetAllBrews);
		while(results.next()) {
			Brewery aBrewery = mapRowToBrewery(results);
			breweryList.add(aBrewery);
		}
		return breweryList;
	}

	@Override
	public Brewery getBreweryById(int id) {
		String sqlGetBrewery = "SELECT * FROM breweries WHERE id = ?";
		SqlRowSet result = template.queryForRowSet(sqlGetBrewery, id);
		result.next();
		Brewery aBrewery = mapRowToBrewery(result);
		return aBrewery;
	}
	
	@Override
	public List<Beer> getBeersByBreweryId(int breweryId){
		List<Beer> beerListbyBrewery = new ArrayList<>();
		String sqlGetBeersByBrew = "SELECT * FROM beers JOIN breweries ON beers.brewery_id = breweries.id WHERE brewery_id = ?";
		SqlRowSet result = template.queryForRowSet(sqlGetBeersByBrew, breweryId);
		while(result.next()) {
			Beer beer = (mapResultToBeer(result));
			beerListbyBrewery.add(beer);
		}
		return beerListbyBrewery;
	}
	
	@Override
	public void deleteBrewery(int id) {
		String sqlDeleteBrewery = "DELETE FROM breweries WHERE id = ?";
		template.update(sqlDeleteBrewery, id);
	}
	
	@Override
	public void createBrewery(Brewery newBrewery) { 
		String sqlInsert = "INSERT INTO breweries(name, address1, city, state, zip_code, country, longitude,"
				+ " latitude, phone, website, history, image, active) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		template.update(sqlInsert, newBrewery.getName(),newBrewery.getaddress1(), newBrewery.getCity(), newBrewery.getState(),
				newBrewery.getZipCode(), newBrewery.getCountry(), newBrewery.getLongitude(), newBrewery.getLatitude(),
				newBrewery.getPhoneNumber(), newBrewery.getWebsite(), newBrewery.getHistory(),newBrewery.getImage(),
				newBrewery.isActive());
	} 
	
	@Override
	public void updateBrewery(Brewery aBrewery) { 
		String sqlUpdateBrewery = "UPDATE breweries SET name=?, address1=?, city=?, zip_code=?, state=?, country=?, longitude=?, latitude=?, "
				+ "phone=?, website=?, history=?, image=?, active=? WHERE id=?";
		template.update(sqlUpdateBrewery, aBrewery.getName(),aBrewery.getaddress1(), aBrewery.getCity(), aBrewery.getZipCode(), aBrewery.getState(),
				 aBrewery.getCountry(), aBrewery.getLongitude(), aBrewery.getLatitude(),aBrewery.getPhoneNumber(), aBrewery.getWebsite(), 
				 aBrewery.getHistory(), aBrewery.getImage(), aBrewery.isActive(), aBrewery.getId());
	}
	
	@Override
	public List<Brewery> getAllBreweriesWithGFBeer() {
	    List<Brewery> gFreeList = new ArrayList<>();
	    String sqlGetGfree = "SELECT * FROM breweries JOIN beers ON beers.brewery_id = breweries.id WHERE gluten_free = ?";
	    SqlRowSet result = template.queryForRowSet(sqlGetGfree, true);
	    while(result.next()) {
	        gFreeList.add(mapRowToBrewery(result));
	    }
	   
	    return gFreeList;
	}
	
	private Brewery mapRowToBrewery(SqlRowSet result) {
		Brewery brewery = new Brewery();
		brewery.setId(result.getInt("id"));
		brewery.setActive(result.getBoolean("active"));
		brewery.setCity(result.getString("city"));
		brewery.setCountry(result.getString("country"));
		brewery.setFoodId(result.getInt("food_id"));
		brewery.setHistory(result.getString("history"));
		brewery.setImage(result.getString("image"));
		brewery.setLatitude(result.getDouble("latitude"));
		brewery.setLongitude(result.getDouble("longitude"));
		brewery.setName(result.getString("name"));
		brewery.setPhoneNumber(result.getString("phone"));
		brewery.setState(result.getString("state"));
		brewery.setAddress1(result.getString("address1"));
		brewery.setWebsite(result.getString("website"));
		brewery.setZipCode(result.getString("zip_code"));
				
		return brewery;
	}
	
	private Beer mapResultToBeer(SqlRowSet result) {
		Beer theBeer = new Beer();
		theBeer.setId(result.getInt("id"));
		theBeer.setBreweryId(result.getInt("brewery_id"));
		theBeer.setName(result.getString("name"));
		theBeer.setDescription(result.getString("description"));
		theBeer.setImage(result.getString("image"));
		theBeer.setAbv(result.getDouble("abv"));
		theBeer.setBeerType(result.getString("beer_type"));
		theBeer.setGlutenFree(result.getBoolean("gluten_free"));
		return theBeer;
	}

}

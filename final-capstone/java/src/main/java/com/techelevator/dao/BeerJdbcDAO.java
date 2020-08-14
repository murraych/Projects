package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Beer;

@Component
public class BeerJdbcDAO implements BeerDAO {

	private JdbcTemplate template;

	public BeerJdbcDAO(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Beer> getBeers() {
		List<Beer> beerList = new ArrayList<>();
		String sqlGetBeers = "SELECT * FROM Beers ORDER BY name";
		SqlRowSet result = template.queryForRowSet(sqlGetBeers);
		while (result.next()) {
			Beer beer = mapResultToBeer(result);
			beerList.add(beer);
		}
		return beerList;
	}

	@Override
	public Beer getBeerById(int breweryId, int id) {
		String sqlGetBeer = "SELECT * FROM beers JOIN breweries ON beers.brewery_id = breweries.id "
				+ "WHERE breweries.id = ? AND beers.id = ?";
		SqlRowSet result = template.queryForRowSet(sqlGetBeer, breweryId, id);
		result.next();
		Beer beer = mapResultToBeer(result);
		return beer;
	}

	@Override
	public void addBeer(Beer newBeer) {
		String sqlInsert = "INSERT INTO beers(brewery_id, name, description, image, abv, beer_type, gluten_free)"
				+ "VALUES (?,?,?,?,?, (SELECT id FROM beer_type WHERE name = ? LIMIT 1),?)";
		template.update(sqlInsert, newBeer.getBreweryId(), newBeer.getName(), newBeer.getDescription(),
				newBeer.getImage(), newBeer.getAbv(), newBeer.getBeerType(), newBeer.isGlutenFree());
	}

	@Override
	public void deleteBeer(int id) {
		String sqlDeleteBeer = "DELETE FROM beers WHERE id = ?";
		template.update(sqlDeleteBeer, id);
	}

	@Override
	public void deleteBeersByBrewery(int breweryId) {
		String sqlDeleteAllBeers = "DELETE FROM beers WHERE brewery_id = ?";
		template.update(sqlDeleteAllBeers, breweryId);
	}

	@Override
	public void updateBeer(Beer beerToUpdate) {
		String sqlUpdateBeer = "UPDATE beers SET brewery_id=?, name=?, description=?, image=?, abv=?, beer_type=?, "
				+ "gluten_free=? WHERE id=?";
		template.update(sqlUpdateBeer, beerToUpdate.getBreweryId(), beerToUpdate.getName(),
				beerToUpdate.getDescription(), beerToUpdate.getImage(), beerToUpdate.getAbv(),
				beerToUpdate.getBeerTypeId(), beerToUpdate.isGlutenFree(), beerToUpdate.getId());
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

//	@Override
//	public List<Beer> getAllGlutenFreeBeers() {
//		List<Beer> beerList = new ArrayList<>();
//		String sqlGetBeers = "SELECT * FROM beers WHERE gluten_free = true";
//		SqlRowSet result = template.queryForRowSet(sqlGetBeers);
//		while (result.next()) {
//			Beer beer = mapResultToBeer(result);
//			beerList.add(beer);
//		}
//		return beerList;
//	}
}
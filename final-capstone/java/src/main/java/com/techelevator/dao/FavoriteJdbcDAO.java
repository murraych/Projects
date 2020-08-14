package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Favorite;

@Component
public class FavoriteJdbcDAO implements FavoriteDAO {
	private JdbcTemplate template;
	
	public FavoriteJdbcDAO(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Favorite> listAllFavorites(int userId) {
		List<Favorite> favoriteList = new ArrayList<>();
		String sqlFavorite = "SELECT b.name, f.user_id, f.brewery_id from favorite_breweries f JOIN breweries b ON brewery_id = b.id WHERE f.user_id = ?";
		SqlRowSet result = template.queryForRowSet(sqlFavorite, userId);
		while (result.next()) {
			Favorite favorite = mapRowToFavorite(result);
			favoriteList.add(favorite);
		}
		return favoriteList;
	}

	@Override
	public void addFavorite(Favorite favorite) {
		String sqlAddFavorite = "INSERT INTO favorite_breweries (user_id, brewery_id) VALUES (?,?)";
		template.update(sqlAddFavorite, favorite.getUserId(), favorite.getBreweryId());
	}

	@Override
	public void removeFavorite(int userId, int breweryId) {
		String sqlRemoveFavorite = "DELETE FROM favorite_breweries WHERE brewery_id = ? AND user_id = ?";
		template.update(sqlRemoveFavorite, breweryId, userId);
	}
	
	@Override
	public void removeFavoritesByBrewery(int breweryId) {
		String sqlRemoveFavorites = "DELETE FROM favorite_breweries WHERE brewery_id = ?";
		template.update(sqlRemoveFavorites, breweryId);
	}
	
	@Override
	public int deleteFavoritesByUserId(int userId) {
		String deleteUserFavorites = "DELETE FROM favorite_breweries WHERE user_id = ?";
		int favoritesDeleted = template.update(deleteUserFavorites, userId);
		return favoritesDeleted;
	}

	private Favorite mapRowToFavorite(SqlRowSet result) {
		Favorite favorite = new Favorite();
		favorite.setUserId(result.getInt("user_id"));
		favorite.setBreweryId(result.getInt("brewery_id"));
		favorite.setBreweryName(result.getString("name"));
		return favorite;
	}

}

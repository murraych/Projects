package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.BeerType;

@Component
public class BeerTypeJdbcDAO implements BeerTypeDAO{
	
	private JdbcTemplate template;
	public BeerTypeJdbcDAO(JdbcTemplate jdbcTemplate) {
		this.template = jdbcTemplate;
	}
	
	@Override
	public List<BeerType> listAllBeerTypes() {
		List<BeerType> allTypes = new ArrayList<>();
		String sqlBeerTypes = "SELECT * FROM beer_type";
		SqlRowSet result = template.queryForRowSet(sqlBeerTypes);
		while(result.next()) {
			BeerType type = mapRowToBeerType(result);
			allTypes.add(type);
		}
		return allTypes;
	}
	
	@Override
	public void addNewBeerType(BeerType newType) {
		String sqlInsertType = "INSERT INTO beer_type(name) VALUES(?)";
		template.update(sqlInsertType, newType.getName());
	}
	
	@Override
	public void updateBeerType(BeerType type) {
		String sqlUpdate = "UPDATE beer_type SET name = ? WHERE id = ?";
		template.update(sqlUpdate, type.getName(), type.getId());
	}
	
	@Override
	public void deleteBeerType(int id) {
		String sqlDelete = "DELETE FROM beer_type WHERE id = ?";
		template.update(sqlDelete, id);
	}
	
	
	
	private BeerType mapRowToBeerType(SqlRowSet result) {
		BeerType type = new BeerType();
		type.setId(result.getInt("id"));
		type.setName(result.getString("name"));
		return type;
	}
}

package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;

@Component
public class JDBCCatCardDAO implements CatCardDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCCatCardDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CatCard> list() {
		List<CatCard> catCardList = new ArrayList<>();
		String sqlGetListOfCards = "SELECT  * FROM catcards";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetListOfCards);
		
		while(results.next()) {
			CatCard card = mapRowToCard(results);
			catCardList.add(card);
		}
		
		return catCardList;
	}

	@Override
	public CatCard get(long id) {
		

		return null;
	}

	@Override
	public boolean update(long cardId, CatCard changedCard) {
		return false;
	}

	@Override
	public boolean delete(long id) {
		return false;
	}

	@Override
	public boolean save(CatCard card) {
		return false;
	}

	private boolean exists(long id) {
		return false;
	}
	
	private CatCard mapRowToCard(SqlRowSet rs) {
		CatCard cc = new CatCard();
		cc.setCatCardId(rs.getLong("id"));
		cc.setImgUrl(rs.getString("img_url"));
		cc.setCatFact(rs.getString("fact"));
		cc.setCaption(rs.getString("caption"));

		return cc;
	}

	
	
}

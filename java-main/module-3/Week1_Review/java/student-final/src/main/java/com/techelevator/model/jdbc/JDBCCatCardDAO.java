package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatCardNotFoundException;

@Component
public class JDBCCatCardDAO implements CatCardDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCCatCardDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CatCard> list() {
		List<CatCard> catCardList = new ArrayList<>();
		String sqlGetListOfCards = "SELECT * FROM catcards";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetListOfCards);
		
		while(results.next()) {
			CatCard card = mapRowToCard(results);
			catCardList.add(card);
		}
		
		return catCardList;
	}

	@Override
	public CatCard get(long id) {
		CatCard card = null;
		String sql = "SELECT * FROM catcards WHERE id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			card = mapRowToCard(results);
		} else {
			throw new CatCardNotFoundException();
		}
		
		return card;
	}

	@Override
	public boolean update(long cardId, CatCard changedCard) {
		String sql = "UPDATE catcards SET caption = ? WHERE id = ?";
		
		return jdbcTemplate.update(sql, changedCard.getCaption(), cardId) == 1;
	}

	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM catcards WHERE id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	@Override
	public boolean save(CatCard card) {
		String sql = "INSERT INTO catcards (img_url, fact, caption) VALUES (?, ?, ?) RETURNING id";
		long id = jdbcTemplate.queryForObject(sql, Long.class, card.getImgUrl(), card.getCatFact(), card.getCaption());
		if (id > 0) {
			return true;
		}
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

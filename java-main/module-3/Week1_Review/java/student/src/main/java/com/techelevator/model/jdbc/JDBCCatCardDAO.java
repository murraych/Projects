package com.techelevator.model.jdbc;

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
		return null;
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

		return cc;
	}

}

package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;


@Component
public class AccountSqlDAO implements AccountDAO {
	
	private JdbcTemplate jdbcTemplate;

	public AccountSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override //not sure if I should be sending in user object or name here to retrive
	public Account getBalance(String username) {
		
		Account account = null;

		
		String sql = "SELECT acc.* FROM accounts AS acc JOIN users "
				+ "ON users.user_id = acc.user_id WHERE users.username = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
		
		if(results.next()) {
			account = mapRowToAccount(results);
		}
		
		return account;
	}

	@Override
	public void addToBalance(BigDecimal amount, int userId) {
		
		Account account = null;
		String sqlRetrieveBalance = "SELECT * FROM accounts WHERE user_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlRetrieveBalance,userId);
		
		if(results.next()) {
			account = mapRowToAccount(results);
			
		}
		
		BigDecimal balance = account.getBalance();
		balance = balance.add(amount);
		
		String sqlUpdateBalance = "UPDATE accounts SET balance = ? WHERE user_id = ?";
		
		jdbcTemplate.update(sqlUpdateBalance, balance, userId);
		
		
		
	}

	@Override
	public void subtractFromBalance(BigDecimal amount, int userId) {
		Account account = null;
		String sqlRetrieveBalance = "SELECT * FROM accounts WHERE user_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlRetrieveBalance,userId);
		
		if(results.next()) {
			account = mapRowToAccount(results);
			
		}
		
		BigDecimal balance = account.getBalance();
		balance = balance.subtract(amount);
		
		String sqlUpdateBalance = "UPDATE accounts SET balance = ? WHERE user_id = ?";
		
		jdbcTemplate.update(sqlUpdateBalance, balance, userId);
	}
	
	private Account mapRowToAccount(SqlRowSet rs) {
		Account account = new Account();
		account.setAccountId(rs.getInt("account_id"));
		account.setBalance(rs.getBigDecimal("balance"));
		account.setUserId(rs.getInt("user_id"));
		return account;
		
	}

}

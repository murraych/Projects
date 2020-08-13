package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Puppy;

@Component
public class PuppySqlDao implements PuppyDAO {

	private JdbcTemplate template;

	public PuppySqlDao(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Puppy> getAllPuppies() {
		String sqlPuppy = "SELECT * from puppies";
		SqlRowSet result = template.queryForRowSet(sqlPuppy);
		return mapResultsToPuppies(result);
	}

	private Puppy mapResultToPuppy(SqlRowSet result) {
		Puppy retrievedPuppy = new Puppy(result.getInt("id"), result.getString("name"), result.getInt("weight"),
				result.getString("gender"), result.getBoolean("paper_trained"));

		return retrievedPuppy;
	}

	private List<Puppy> mapResultsToPuppies(SqlRowSet results) {
		List<Puppy> retrievedPuppies = new ArrayList<>();
		while (results.next()) {
			retrievedPuppies.add(mapResultToPuppy(results));
		}

		return retrievedPuppies;
	}

}

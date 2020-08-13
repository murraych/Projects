package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.techelevator.exceptions.PuppyNotFoundException;
import com.techelevator.model.Puppy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * PuppyJdbcDao
 */
@Component
public class PuppyJdbcDao implements PuppyDao {

	private JdbcTemplate template;

	public PuppyJdbcDao(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Puppy> getPuppies() {
		String sqlGetPuppy = "SELECT * FROM puppies";
		SqlRowSet result = template.queryForRowSet(sqlGetPuppy);
		return mapResultsToPuppies(result);
	}

	@Override
	public Puppy getPuppy(int id) {
		String sqlGetPuppy = "SELECT * FROM puppies WHERE id=?";
		SqlRowSet result = template.queryForRowSet(sqlGetPuppy, id);
		if (result.next()) {
			return mapResultToPuppy(result);
		} else {
			throw new PuppyNotFoundException();
		}
	}

	@Override
	public void removePuppy(int id) {
		String sqlRemovePuppy = "DELETE FROM puppies WHERE id=?";
		template.update(sqlRemovePuppy, id);
	}

	@Override
	public void savePuppy(Puppy puppyToSave) {
		String sqlAddPuppy = "INSERT INTO puppies " + "(name, weight, gender, paper_trained) VALUES " + "(?, ?, ?, ?)";
		template.update(sqlAddPuppy, puppyToSave.getName(), puppyToSave.getWeight(), puppyToSave.getGender(),
				puppyToSave.isPaperTrained());

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

	@Override
	public void editPuppy(Puppy puppyToSave) {

		System.out.println("name: " + puppyToSave.getName());
		String sqlUpdPuppy = "UPDATE puppies " + "SET weight = ? , paper_trained = ? WHERE id=?";
		template.update(sqlUpdPuppy, puppyToSave.getWeight(), puppyToSave.isPaperTrained(), puppyToSave.getId());
	}
}
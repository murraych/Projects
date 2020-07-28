package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCReservationDAO implements ReservationDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public String createReservation(Reservation notYetSaved) {
		String sqlCreateReservation = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date)"
				+ "VALUES (?, ?, ?, ?, ?)";
		String sqlGetId = "SELECT reservation_id FROM reservation WHERE site_id = ? AND name = ? AND from_date = ? AND to_date = ? AND create_date = ?";
		jdbcTemplate.update(sqlCreateReservation, notYetSaved.getSiteId(), notYetSaved.getName(),
				notYetSaved.getStartDate(), notYetSaved.getEndDate(), notYetSaved.getReserveDate());
		SqlRowSet idResult = jdbcTemplate.queryForRowSet(sqlGetId, notYetSaved.getSiteId(), notYetSaved.getName(),
				notYetSaved.getStartDate(), notYetSaved.getEndDate(), notYetSaved.getReserveDate());

		if (idResult.next()) {

			notYetSaved.setReservationId(idResult.getLong("reservation_id"));
			return "The reservation has been made and the confirmation id is " + notYetSaved.getReservationId();
		}

		return "I'm sorry your reservation was not successfully created.";
	}

	@Override
	public List<Reservation> searchReservationsByName(String name) {
		List<Reservation> reservations = new ArrayList<>();
		String sqlReservation = "SELECT * FROM reservation WHERE name ILIKE ?";
		SqlRowSet reservationResults = jdbcTemplate.queryForRowSet(sqlReservation, "%" + name + "%");
		while (reservationResults.next()) {
			reservations.add(
					new Reservation(reservationResults.getLong("reservation_id"), reservationResults.getLong("site_id"),
							reservationResults.getString("name"), reservationResults.getDate("from_date").toLocalDate(),
							reservationResults.getDate("to_date").toLocalDate(),
							reservationResults.getDate("create_date").toLocalDate()));
		}
		return reservations;
	}

	@Override
	// TODO do we care about using mapRowToReservation? Then add?
	public List<Reservation> getAllReservationsBySite(long siteId) {
		List<Reservation> reservations = new ArrayList<>();
		String sqlReservation = "SELECT * FROM reservation WHERE site_id = ?";
		SqlRowSet reservationResults = jdbcTemplate.queryForRowSet(sqlReservation, siteId);
		while (reservationResults.next()) {
			reservations.add(
					new Reservation(reservationResults.getLong("reservation_id"), reservationResults.getLong("site_id"),
							reservationResults.getString("name"), reservationResults.getDate("from_date").toLocalDate(),
							reservationResults.getDate("to_date").toLocalDate(),
							reservationResults.getDate("create_date").toLocalDate()));
		}
		return reservations;
	}

//	@Override
//	public List<Reservation> getAllReservationsByCampground(long campgroundId) {
//		List<Reservation> reservations = new ArrayList<>();
//		String sqlReservation = "SELECT r.* FROM reservation AS r "
//				+ "INNER JOIN site AS s ON r.site_id = s.site_id "
//				+ "WHERE s.campground_id = ?";
//		SqlRowSet reservationResults = jdbcTemplate.queryForRowSet(sqlReservation, campgroundId);
//		while (reservationResults.next()) {
//			reservations.add(new Reservation(reservationResults.getLong("reservation.reservation_id"), reservationResults.getLong("reservation.site_id"), 
//					reservationResults.getString("reservation.name"), reservationResults.getDate("reservation.from_date").toLocalDate(), 
//					reservationResults.getDate("reservation.to_date").toLocalDate(), reservationResults.getDate("reservation.create_date").toLocalDate()));
//		}
//		return reservations;
//	}

	@Override
	public List<Reservation> getAllReservationsByPark(long parkId) {
		List<Reservation> reservations = new ArrayList<>();
		String sqlReservation = "SELECT r.* FROM reservation AS r INNER JOIN site AS s ON r.site_id = s.site_id INNER JOIN campground AS c ON s.campground_id = c.campground_id WHERE c.park_id = ?";
		SqlRowSet reservationResults = jdbcTemplate.queryForRowSet(sqlReservation, parkId);
		while (reservationResults.next()) {
			Reservation nextReservation = mapRowToReservation(reservationResults);
			reservations.add(nextReservation);
//			reservations.add(new Reservation(reservationResults.getLong("reservation.reservation_id"), reservationResults.getLong("reservation.site_id"), 
//					reservationResults.getString("reservation.name"), reservationResults.getDate("reservation.from_date").toLocalDate(), 
//					reservationResults.getDate("reservation.to_date").toLocalDate(), reservationResults.getDate("reservation.create_date").toLocalDate()));
		}
		return reservations;
	}

//	@Override
//	public BigDecimal calculateTotalCost(long siteId, LocalDate startDate, LocalDate endDate) {
//		// Table site connects to table campground, which has the daily_fee column
//		JDBCSiteDAO siteDao = new JDBCSiteDAO(dataSource);
//		return null;
//	}

	@Override
	public Reservation searchByReservationId(long reservationId) {
		String sqlSearchReservationId = "SELECT * FROM reservation WHERE reservation_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSearchReservationId, reservationId);
		if (result.next()) {
			// Weak crazed laughter upon remembering we'd already made the helper method
			Reservation found = mapRowToReservation(result);
			return found;
		}
		return null;
	}

	@Override
	public List<Reservation> checkAvailable(LocalDate start, LocalDate end, Campground campground) {
		List<Reservation> conflicts = new ArrayList<>();
		String sqlCheckStartDuring = "SELECT r.* FROM reservation AS r INNER JOIN site AS s"
				+ " ON r.site_id = s.site_id"
				+ " WHERE s.campground_id = ? AND (from_date BETWEEN ? AND ?)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCheckStartDuring, campground.getcampgroundId(), start, end);
		while (results.next()) {
			Reservation reservation = mapRowToReservation(results);
			conflicts.add(reservation);
		}
		String sqlCheckEndDuring = "SELECT r.* FROM reservation AS r INNER JOIN site AS s"
				+ " ON r.site_id = s.site_id"
				+ " WHERE s.campground_id = ? AND (to_date BETWEEN ? AND ?)";
		SqlRowSet results1 = jdbcTemplate.queryForRowSet(sqlCheckEndDuring, campground.getcampgroundId(), start, end);
		while (results1.next()) {
			Reservation reservation = mapRowToReservation(results1);
			conflicts.add(reservation);
		}

		String sqlIncluding = "SELECT r.* FROM reservation AS r INNER JOIN site AS s"
				+ " ON r.site_id = s.site_id"
				+ " WHERE s.campground_id = ? AND (from_date < ? AND to_date > ?)";
		SqlRowSet results2 = jdbcTemplate.queryForRowSet(sqlIncluding, campground.getcampgroundId(), start, end);
		while (results2.next()) {
			Reservation reservation = mapRowToReservation(results2);
			conflicts.add(reservation);
		}
		return conflicts;
	}
	
	// If we wanted to do the BONUS for park off-seasons
	// If LocalDate.start.getMonth not between parkOpenmm and parkClosemm
//	public boolean checkParkOpen(LocalDate start, LocalDate end, long parkIdNumber) {
//		
//		return false;
//	}

	private Reservation mapRowToReservation(SqlRowSet reservationResults) {
		Reservation theReservation;
		theReservation = new Reservation();
		theReservation.setReservationId(reservationResults.getLong("reservation_id"));
		theReservation.setSiteId(reservationResults.getLong("site_id"));
		theReservation.setName(reservationResults.getString("name"));
		theReservation.setStartDate(reservationResults.getDate("from_date") == null ? null
				: reservationResults.getDate("from_date").toLocalDate());
		theReservation.setEndDate(reservationResults.getDate("to_date") == null ? null
				: reservationResults.getDate("to_date").toLocalDate());
		theReservation.setReserveDate(reservationResults.getDate("create_date") == null ? null
				: reservationResults.getDate("create_date").toLocalDate());

		return theReservation;
	}
}

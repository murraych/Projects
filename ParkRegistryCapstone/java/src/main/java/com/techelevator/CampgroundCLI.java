package com.techelevator;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.view.Menu;

public class CampgroundCLI {

	private Menu menu;
	private JDBCParkDAO parkDao;
	private JDBCCampgroundDAO campgroundDao;
	private JDBCSiteDAO siteDao;
	private JDBCReservationDAO reservationDao;

	// Menu fun
	private List<Park> mainMenuOptions;
	private Object[] mainMenuOptionsArray;
	private static final String MENU_OPTION_GO_BACK = "Return to Previous Screen";

	private static final String PARK_MENU_OPTION_VIEW = "View Campgrounds";
	private static final String PARK_MENU_OPTION_SEARCH = "Search for Existing Reservation";
	private static final String[] PARK_MENU_OPTIONS = { PARK_MENU_OPTION_VIEW, PARK_MENU_OPTION_SEARCH,
			MENU_OPTION_GO_BACK };

	private static final String EXISTING_RESERVATIONS_MENU_OPTION_BY_NAME = "Search for existing reservation by name";
	private static final String EXISTING_RESERVATIONS_MENU_OPTION_BY_PARK = "Search for existing reservation by park";
	private static final String EXISTING_RESERVATIONS_MENU_OPTION_BY_ID = "Search for existing reservation by Confirmation ID";
	private static final String[] EXISTING_RESERVATIONS_MENU_OPTIONS = { EXISTING_RESERVATIONS_MENU_OPTION_BY_NAME,
			EXISTING_RESERVATIONS_MENU_OPTION_BY_PARK, EXISTING_RESERVATIONS_MENU_OPTION_BY_ID, MENU_OPTION_GO_BACK };
	
	// campground menu
	private static final String CAMPGROUND_MENU_OPTION_SEARCH = "Search for Available Reservation";
	private static final String[] CAMPGROUND_MENU_OPTIONS = { CAMPGROUND_MENU_OPTION_SEARCH, MENU_OPTION_GO_BACK };

	public static void main(String[] args) throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
		dataSource.close();
	}

	// Menu and CampgroundCLI classes tested manually :D
	public CampgroundCLI(DataSource datasource) {
		this.menu = new Menu(System.in, System.out);

		// create your DAOs here
		parkDao = new JDBCParkDAO(datasource);
		campgroundDao = new JDBCCampgroundDAO(datasource);
		siteDao = new JDBCSiteDAO(datasource);
		reservationDao = new JDBCReservationDAO(datasource);

		// Initialize main menu using parkDao
		mainMenuOptions = parkDao.getAllParks();
		mainMenuOptionsArray = new Object[mainMenuOptions.size() + 1];
		for (int i = 0; i < mainMenuOptions.size(); i++) {
			mainMenuOptionsArray[i] = mainMenuOptions.get(i);
		}
		mainMenuOptionsArray[mainMenuOptionsArray.length - 1] = "Quit";
	}

	public void run() throws SQLException {
		displayApplicationBanner();
		while (true) {
			printHeading("View Parks Interface");
			Park choice;
			try {
				choice = (Park) menu.getChoiceFromOptions(mainMenuOptionsArray);
				handleParkChoice(choice);
			} catch (ClassCastException ex) {
				this.menu.closeStreams();
				System.exit(0);
			}
		}
	}

	private void handleParkChoice(Object choice) {
		while (true) {
			printHeading("Park Information Screen");
			// Should display detailed park info
			Park park = (Park) choice;
			System.out.println(park.getParkDetails());
			System.out.println();
			System.out.println("Select a command:");
			String parkChoice = (String) menu.getChoiceFromOptions(PARK_MENU_OPTIONS);
			if (parkChoice.equals(PARK_MENU_OPTION_VIEW)) {
				handleCampgroundView((Park) choice);
			} else if (parkChoice.equals(PARK_MENU_OPTION_SEARCH)) {
				handleReservationSearch();
			} else if (parkChoice.equals(MENU_OPTION_GO_BACK)) {
				return;
			} else {
				System.out.println("*******Not a valid option*******");
			}
		}
	}

	private void printHeading(String headingText) {
		System.out.println("\n" + headingText);
		for (int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private void displayApplicationBanner() {
		System.out.println();
		System.out.println("Welcome to the Campground Reservations System!");
		System.out.println();
	}

	private void printCampgrounds(List<Campground> campgrounds) {
		// Heading
		// TODO
		System.out.printf("\n%-8s %-30s%-15s%-15s%s", "", "Name", "Open", "Close", "Daily Fee");
		// Contents
		for (Campground campground : campgrounds) {
			int number = campgrounds.indexOf(campground) + 1;
			System.out.printf("\n#%-8d%s", number, campground);
		}
		System.out.println();
	}

	private void handleCampgroundView(Park park) {
		while (true) {
			printHeading("Park Campgrounds");
			// Should display all campgrounds
			List<Campground> parkCampground = campgroundDao.getAllCampgroundsByPark(park.getPark_id());
			printCampgrounds(parkCampground);
			System.out.println();
			System.out.println("Select a command:");

			String campChoice = (String) menu.getChoiceFromOptions(CAMPGROUND_MENU_OPTIONS);
			if (campChoice.equals(CAMPGROUND_MENU_OPTION_SEARCH)) {
				handleSearchAvailable(park);
			} else if (campChoice.equals(MENU_OPTION_GO_BACK)) {
				return;
			} else {
				System.out.println("*******Not a valid option*******");
			}
		}
	}

	private void handleSearchAvailable(Park park) {
		while (true) {
			printHeading("Search for Campground Reservation");
			List<Campground> parkCampground = campgroundDao.getAllCampgroundsByPark(park.getPark_id());
			Object[] availableSitesMenu = new Object[parkCampground.size() + 1];
			for (int i = 0; i < parkCampground.size(); i++) {
				availableSitesMenu[i] = parkCampground.get(i);
			}
			availableSitesMenu[parkCampground.size()] = "Cancel";
			System.out.println();
			System.out.println("Select a command:");
			// Heading - Make pretty
			// TODO
			System.out.printf("\n%-30s%-15s%-15s%s", "Name", "Open", "Close", "Daily Fee");
			Campground choice;
			try {
				choice = (Campground) menu.getChoiceFromOptions(availableSitesMenu);
				handleCampgroundChoice(choice);
			} catch (ClassCastException ex) {
				// This is the cancel option
				return;
			}
		}
	}

	private void handleCampgroundChoice(Campground campground) {
		// This is the screen where we must handle dates
		// TODO
		while (true) {
			LocalDate startDate = LocalDate.now();
			LocalDate endDate = LocalDate.now();
			System.out.println();
			System.out.println("Did you want to check reservation times? (Y/N) ");
			String response = menu.getStringInput();
			if (response.equalsIgnoreCase("y")) {

				System.out.println("What is the arrival date (MM-DD-YYYY)? ");
				startDate = menu.getDate();
				if (startDate == null) {
					continue;
				} else if (startDate.isBefore(LocalDate.now())) {
					System.out.println("Please choose a start date on or after today.");
					// TODO infinite loop with no cancel
					continue;
				}
				System.out.println("What is the departure date (MM-DD-YYYY)? ");
				endDate = menu.getDate();
				if (endDate == null) {
					continue;
				} else if (endDate.isBefore(startDate)) {
					System.out.println("Please choose an end date after or on the requested start date.");
					continue;
				}
				handleSiteChoice(startDate, endDate, campground);
			} else
				return;
		}
	}

	private void handleSiteChoice(LocalDate start, LocalDate end, Campground campgroundChoice) {
		List<Reservation> conflicts = reservationDao.checkAvailable(start, end, campgroundChoice);
		boolean canSchedule = (conflicts.isEmpty());
		List<Site> noConflicts = new ArrayList<>();

		if (canSchedule) {
			List<Site> allSites = siteDao.getAllSitesByCampground(campgroundChoice.getcampgroundId());
			Set<Long> siteIdsWithScheduleConflict = new HashSet<Long>();
			for (Reservation scheduleConflict : conflicts) {
				siteIdsWithScheduleConflict.add(scheduleConflict.getSiteId());
			}
			for (Site potentialSite : allSites) {
				if (!siteIdsWithScheduleConflict.contains(potentialSite.getSiteId())) {
					noConflicts.add(potentialSite);
					if (noConflicts.size() == 5) {
						break;
					}
				}
			}

			// Display heading
			printHeading("Results Matching Your Search Criteria");
			// TODO does this still look wonky?
			String tableHeading = String.format("   %-10s%-10s%-20s%-20s%-10s%s", "Site No.", "Max Occup.",
					"Accessible?", "Max RV Length", "Utility", "Cost");
			System.out.println(tableHeading);

			// Array of menu options
			Object[] siteOptions = new Object[noConflicts.size() + 1];
			for (int i = 0; i < noConflicts.size(); i++) {
				Site siteWithCost = noConflicts.get(i);
				siteWithCost.setTotalCost(siteDao.calculateTotalCost(campgroundChoice.getcampgroundId(), start, end));
				siteOptions[i] = noConflicts.get(i);
			}
			siteOptions[noConflicts.size()] = "Cancel";

			// Get reservation choice
			Site siteChoice;
//			System.out.println("Which site should be reserved?");
			try {
				siteChoice = (Site) menu.getChoiceFromOptions(siteOptions);
				handleReservation(siteChoice, start, end);
			} catch (ClassCastException ex) {
				// This is the cancel option
				return;
			}
		} else {
			System.out.println(
					"Sorry! No sites available during this time. Please try a different time window or campground.");
			return;
		}
	}

	private void handleReservation(Site choice, LocalDate startDate, LocalDate endDate) {
		Reservation createdReservation = new Reservation();
		System.out.println("What name should the resrvation be made under?");
		createdReservation.setName(menu.getStringInput());
		createdReservation.setSiteId(choice.getSiteId());
		createdReservation.setStartDate(startDate);
		createdReservation.setEndDate(endDate);
		createdReservation.setReserveDate(LocalDate.now());
		System.out.println(reservationDao.createReservation(createdReservation));
		return;
	}

	private void handleReservationSearch() {
		while (true) {
			printHeading("Search Existing Reservations");
			String choice = (String) menu.getChoiceFromOptions(EXISTING_RESERVATIONS_MENU_OPTIONS);
			if (choice.equals(EXISTING_RESERVATIONS_MENU_OPTION_BY_NAME)) {
				handleReservationNameSearch();
			} else if (choice.equals(EXISTING_RESERVATIONS_MENU_OPTION_BY_PARK)) {
				handleReservationSearchByPark();
			} else if (choice.equals(EXISTING_RESERVATIONS_MENU_OPTION_BY_ID)) {
				handleReservationIdSearch();
			} else return;
		}
	}

	private void handleReservationNameSearch() {
		System.out.println("Please enter the name holding the reservation");
		String searchName = menu.getStringInput();
		List<Reservation> reservationNameResults = reservationDao.searchReservationsByName(searchName);
		if (reservationNameResults.isEmpty()) {
			System.out.println("No reservation found under name " + searchName);
		} else {
			printExistingReservationHeading(); 
			for (int i = 0; i < reservationNameResults.size(); i++) {
				System.out.println(reservationNameResults.get(i));
			}
		}
	}

	private void handleReservationSearchByPark() {
		while (true) {
			printHeading("Search existing reservations by Park");
			Park choice;
			try {
				choice = (Park) menu.getChoiceFromOptions(mainMenuOptionsArray);
			} catch (ClassCastException ex) {
				return;
			}
			List<Reservation> reservationList = reservationDao.getAllReservationsByPark(choice.getPark_id());
			if (reservationList.isEmpty()) {
				System.out.println("No reservations found in " + choice.getName());
			} else {
				printExistingReservationHeading(); 
				for (int i = 0; i < reservationList.size(); i++) {
					System.out.println(reservationList.get(i));
				}
			}
		}

	}

	private void handleReservationIdSearch() {
		System.out.println("Please enter the Confirmation ID of your reservation");
		String confirmationId = menu.getStringInput();
		long confirmationNumber = 0;
		try {
			confirmationNumber = Long.parseLong(confirmationId);
		} catch (NumberFormatException ex) {
			System.out.println("Not a valid ID number");
			return;
		}
		Reservation reservation = reservationDao.searchByReservationId(confirmationNumber);
		if (reservation == null) {
			System.out.println("No reservation found for Confirmation ID " + confirmationId);
		} else {
			printExistingReservationHeading(); 
			System.out.println(reservation);

		}
	}
	
	private void printExistingReservationHeading() {
		String reservationHeading = String.format("%-12s%-10s%-35s%-15s%-15s%-15s", "Confirm ID", "Site No.",
				"Name", "Arriving", "Departing", "Reservation Made");
		printHeading(reservationHeading);
	}

}

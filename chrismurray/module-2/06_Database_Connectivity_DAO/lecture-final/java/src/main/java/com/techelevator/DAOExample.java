package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		CityDAO dao = new JDBCCityDAO(worldDataSource);
		
		City thisCity = new City();
		thisCity.setCountryCode("USA");
		thisCity.setDistrict("PA");
		thisCity.setName("Horsham");
		thisCity.setPopulation(15000);
		
		dao.save(thisCity);
		
		City theCity = dao.findCityById(thisCity.getId());
		
		System.out.println(theCity.getName() + " has been created!");
		
	}

}

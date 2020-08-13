package com.techelevator.city;

public class City {

	private String full_name;
	private int geoname_id;
	private long population;
	
	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public City() {
	}

	
	
	
	@Override
	public String toString() {
		return full_name +  "\n" + geoname_id +
				"\nPopulation: " + population;
	}




	public String getFull_name() {
		return full_name;
	}




	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}




	public int getGeoname_id() {
		return geoname_id;
	}




	public void setGeoname_id(int geoname_id) {
		this.geoname_id = geoname_id;
	}
}

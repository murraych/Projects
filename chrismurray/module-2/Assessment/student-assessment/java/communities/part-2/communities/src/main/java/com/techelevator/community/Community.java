package com.techelevator.community;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Community {
	private Long id;
	private String name;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private LocalDate created;
	private boolean live;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Community(String name, BigDecimal latitude,
			BigDecimal longitude, LocalDate created, boolean live) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.created = created;
		this.live = live;
	}

	public Community() {
	}


}

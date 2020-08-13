package com.techelevator.cart;

import java.time.LocalDate;

public class Cart {
	private Long id;
	private String username;
	private String cookieValue;
	private LocalDate created;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCookieValue() {
		return cookieValue;
	}

	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public Cart(String username, String cookieValue, LocalDate created) {
		this.username = username;
		this.cookieValue = cookieValue;
		this.created = created;
	}

	public Cart() {}

}

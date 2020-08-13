package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatFact;

@Component
public class RestCatFactService implements CatFactService {

	private static final String API_URL = "https://cat-fact.herokuapp.com/facts/random";
	private RestTemplate restTemplate = new RestTemplate();
	
	
	@Override
	public CatFact getCatFact() {
		return restTemplate.getForObject(API_URL, CatFact.class);
	}

}

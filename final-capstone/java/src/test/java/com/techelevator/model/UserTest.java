package com.techelevator.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
	
	public User testUser;
	
	@Before
	public void setUp() {
		testUser = new User();
	}
	
	@Test
	public void sameUsersAreSame() {
		User actual = new User();
		
	}

}

package com.techelevator.community;

import java.util.List;

public interface CommunityDao {

	public void save(Community newCommunity);

	public List<Community> getAllCommunities();
}

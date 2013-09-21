package edu.unsw.triangle.data;

import edu.unsw.trianlge.model.Profile;

public interface ProfileDao 
{
	public void insert();
	
	public void delete();
	
	public void update(Profile profile);
	
	public Profile query(String key);

}

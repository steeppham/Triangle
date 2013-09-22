package edu.unsw.triangle.model.data;

import edu.unsw.triangle.model.Profile;

public interface ProfileDao 
{
	public void insert();
	
	public void delete();
	
	public void update(Profile profile);
	
	public Profile query(String key);

}

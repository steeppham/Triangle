package edu.unsw.triangle.data;

import java.util.List;

import edu.unsw.triangle.model.Profile;

public interface ProfileDao
{
	public List<Profile> getAll();
	
	public List<Profile> findById(int id);
	
	public void update(Profile value);
	
	public void detele(Profile value);
}

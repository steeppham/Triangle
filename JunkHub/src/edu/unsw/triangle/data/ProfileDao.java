package edu.unsw.triangle.data;

import java.sql.SQLException;
import java.util.List;

import edu.unsw.triangle.model.Profile;

public interface ProfileDao
{
	public List<Profile> getAll() throws SQLException;
	
	public List<String> getAllUsernames() throws SQLException;
	
	public List<Profile> findById(int id);
	
	public Profile findByUsername(String username) throws SQLException;
	
	public void update(Profile value) throws SQLException;
	
	public void detele(Profile value);
	
	public void insert(Profile value) throws SQLException;
}

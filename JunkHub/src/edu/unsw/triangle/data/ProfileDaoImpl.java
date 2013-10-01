package edu.unsw.triangle.data;

import java.sql.Connection;
import java.util.List;

import edu.unsw.triangle.model.Profile;

public class ProfileDaoImpl extends GenericDao implements ProfileDao
{

	public ProfileDaoImpl(Connection connection) 
	{
		super(connection);
	}

	@Override
	public List<Profile> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profile> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Profile value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detele(Profile value) {
		// TODO Auto-generated method stub
		
	}

}

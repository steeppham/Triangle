package edu.unsw.triangle.service;

import java.sql.SQLException;

import edu.unsw.triangle.data.ConnectionManager;
import edu.unsw.triangle.data.DataSourceException;
import edu.unsw.triangle.data.DerbyDaoManager;
import edu.unsw.triangle.model.Login;
import edu.unsw.triangle.model.Profile;

/**
 * Provides the service layer to operate with Login DAO.
 */
public class LoginService 
{
	//TODO static?
	public static Profile authenticate(Login login) throws DataSourceException, SQLException 
	{
		DerbyDaoManager derbyManager = null;
		Profile profile = null;
		try
		{
			// Check if profile exist
			derbyManager = new DerbyDaoManager(ConnectionManager.getInstance());
			profile = derbyManager.getProfileDao().findByUsername(login.getUsername());
			if (profile == null)
				return null;
			// Check password match
			if (!profile.getPassword().equals(login.getPassword()))
				return null;
		}
		finally
		{
			if (derbyManager != null)
				derbyManager.close();
		}
		
		return profile;
	}
}

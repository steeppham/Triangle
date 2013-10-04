package edu.unsw.triangle.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import edu.unsw.triangle.data.ConnectionManager;
import edu.unsw.triangle.data.DataSourceException;
import edu.unsw.triangle.data.DerbyDaoManager;
import edu.unsw.triangle.data.ProfileDaoImpl;
import edu.unsw.triangle.model.Profile;

public class ProfileService
{
	private static final Logger logger = Logger.getLogger(ProfileService.class.getName());
	
	public static List<Profile> findAllProfiles() throws DataSourceException, SQLException
	{
		DerbyDaoManager derbyManager = null;
		List<Profile> profiles = new ArrayList<Profile>();
		try
		{
			derbyManager = new DerbyDaoManager(ConnectionManager.getInstance());
			// Find all users
			List<String> users = derbyManager.getProfileDao().getAllUsernames();
			// Retrieve profile
			for (String username : users)
			{
				Profile profile = derbyManager.getProfileDao().findByUsername(username);
				if (profile != null)
				{
					profiles.add(profile);
				}
				else
				{
					logger.warning("could not retrieve profile " + username + " from repository");
				}
			}
		}
		finally
		{
			if (derbyManager != null)
				derbyManager.close();
		}
		
		return profiles;
	}

}

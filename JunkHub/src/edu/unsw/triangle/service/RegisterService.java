package edu.unsw.triangle.service;

import java.sql.SQLException;
import java.util.logging.Logger;

import edu.unsw.triangle.data.ConnectionManager;
import edu.unsw.triangle.data.DataSourceException;
import edu.unsw.triangle.data.DerbyDaoManager;
import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.model.Profile.AccountStatus;

public class RegisterService 
{
	private static final Logger logger = Logger.getLogger(RegisterService.class.getName());
	
	public static boolean registerUser(Profile profile) throws SQLException, DataSourceException
	{
		DerbyDaoManager derbyManager = null;
		boolean isNewUser = false;
		try
		{
			derbyManager = new DerbyDaoManager(ConnectionManager.getInstance());
			
			// check if username is free
			if (derbyManager.getProfileDao().findByUsername(profile.getUsername()) == null)
			{
				isNewUser = true;
				// insert new profile into repository
				// set profile to default for new user and set status to pending
				profile.setAdmin(false).setStatus(AccountStatus.PENDING);
				derbyManager.getProfileDao().insert(profile);
				
				// Notify user for confirmation
				NotificationService.notifyConfirmProfile(profile.getEmail(), profile);
			}
		}
		finally
		{
			if (derbyManager != null)
				derbyManager.close();
		}
		
		return isNewUser;
	}

	public static boolean activate(String username, String code) throws SQLException, DataSourceException 
	{
		DerbyDaoManager derbyManager = null;
		boolean isActivated = false;
		try
		{
			derbyManager = new DerbyDaoManager(ConnectionManager.getInstance());
			
			// Check is username has been registered
			Profile profile = derbyManager.getProfileDao().findByUsername(username);
			if (profile != null && profile.getStatus() == AccountStatus.PENDING)
			{
				// Check activation code
				if (profile.hashCode() == Integer.parseInt(code))
				{
					// Update profile status
					derbyManager.getProfileDao().updateStatus(username, AccountStatus.ACTIVE);
					logger.info("username: " + username + " has been activated");
					isActivated = true;
				}
				else
				{
					logger.warning("username: " + username + " does not have correct activation code");
				}
			}
			else
			{
				logger.warning("username: " + username + " is not valid for activation");
			}
		}
		finally
		{
			if (derbyManager != null)
				derbyManager.close();
		}
		
		return isActivated;
	}
}

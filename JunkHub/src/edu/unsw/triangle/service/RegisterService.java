package edu.unsw.triangle.service;

import java.sql.SQLException;

import edu.unsw.triangle.data.ConnectionManager;
import edu.unsw.triangle.data.DataSourceException;
import edu.unsw.triangle.data.DerbyDaoManager;
import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.model.Profile.AccountStatus;

public class RegisterService 
{
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
}

package edu.unsw.triangle.core.service;

import java.util.Date;

import edu.unsw.triangle.model.Keychain;
import edu.unsw.triangle.model.Profile;

public class ProfileService
{
	public static Profile profile(Keychain keychain)
	{
		// Load profile from DAO layer
		Profile profile = null;
		
		// TODO REMOVE
		if (keychain.getUsername().equalsIgnoreCase("stephen"))
		{
			profile = new Profile();
			profile.setUsername("stephen").setFirstname("stephen").setLastname("pham").setAddress("struggle st").
			setDob(new Date()).setEmail("foo@fighters.com").setCredit(12345678);
		}
		
		return profile;
	}

}

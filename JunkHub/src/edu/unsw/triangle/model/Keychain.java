package edu.unsw.triangle.model;

import java.io.Serializable;

/**
 * A bean which represents login state for a user profile. 
 */
public class Keychain implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private boolean isAuthenticated = false;
	
	/**
	 * Default constructor
	 */
	public Keychain() { }
	
	public Keychain(String username, boolean isAuthenticated)
	{
		this.username = username;
		this.isAuthenticated = isAuthenticated;
	}

	public String getUsername() 
	{
		return username;
	}
	
	public boolean isAuthenticated() 
	{
		return isAuthenticated;
	}	
}
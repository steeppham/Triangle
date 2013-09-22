package edu.unsw.triangle.model;

/**
 * Represents the login credentials of a user. 
 */
public class Credential 
{
	private String username;
	private String password;
	
	public Credential(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}

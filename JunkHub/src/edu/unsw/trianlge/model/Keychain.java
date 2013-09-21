package edu.unsw.trianlge.model;

import java.io.Serializable;

public class Keychain implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private boolean isValid;
	private int userId;
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	public Keychain setValid(boolean valid)
	{
		this.isValid = valid;
		return this;
	}
	
}

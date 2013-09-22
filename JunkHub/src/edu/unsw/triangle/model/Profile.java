package edu.unsw.triangle.model;

import java.io.Serializable;

/**
 * A bean that represents a user profile information. 
 */
public class Profile implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int profileId;
	private String username;
	private String password;
	private String nickname;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String dob;
	private int creditNumber;
	private boolean isActive;
	private boolean isAdmin;

}

package edu.unsw.triangle.core.service;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.Credential;
import edu.unsw.triangle.model.Keychain;

/**
 * Provides the service layer to operate with Login DAO.
 */
public class LoginService 
{
	private HttpServletRequest request = null;
	
	public LoginService(HttpServletRequest request)
	{
		this.request = request;
	}

	public static Keychain authenticate(Credential credential) 
	{
		boolean isAuthenticated = false;
		// TODO TESTING: REMOVE FOR DEPLOYMENT
		if (credential.getUsername().equals("stephen"))
		{
			isAuthenticated = true;
		}
		
		// TODO DAO operations here
		// Talk to dao object which talks to database
		// e.g.
		// String password logindao.getpassword(username);
		
		
		Keychain keychain = new Keychain(credential.getUsername(), isAuthenticated);
		return keychain;
	}
}

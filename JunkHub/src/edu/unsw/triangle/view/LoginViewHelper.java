package edu.unsw.triangle.view;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.Credential;
import edu.unsw.triangle.model.Keychain;

/**
 * Represents the login page and provides operations for interacting with UI elements.
 */
public class LoginViewHelper extends ViewHelper
{
	public final static String LOGIN_VIEW = "login.jsp";
	public final static String ATTRIBUTE_MESSAGE = "message";
	public final static String PARAMETER_USERNAME = "username";
	public final static String PARAMETER_PASSWORD = "password";
	public final static String BEAN_KEYCHAIN = "keychain";
	
	public LoginViewHelper(HttpServletRequest request) 
	{
		super(request);
	}

	public void setMessage(String message)
	{
		request.setAttribute(ATTRIBUTE_MESSAGE, message);
	}
	
	public Credential getLogin()
	{
		String username = request.getParameter(PARAMETER_USERNAME);
		String password = request.getParameter(PARAMETER_PASSWORD);
		Credential login = new Credential(username, password);
		return login;
	}
	
	public Keychain getKeychain()
	{
		return (Keychain) request.getSession().getAttribute(BEAN_KEYCHAIN);
	}
	
	public Keychain getKeychain(boolean create)
	{
		Keychain keychain = getKeychain();
		if (keychain == null && create)
		{
			keychain = new Keychain();
		}
		return keychain;
	}
}

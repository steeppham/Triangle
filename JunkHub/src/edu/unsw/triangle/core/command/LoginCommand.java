package edu.unsw.triangle.core.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.core.Command;
import edu.unsw.triangle.view.View;


public class LoginCommand implements Command 
{
	public LoginCommand()
	{
		
	}
	
	/**
	 * Contains logic to check login credentials and initialise a new session.
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		//TODO implement login logic
		
		// Reads in login parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		KeychainDao dao = DaoManager.getKeychain();
//		if (KeychainHandler.authenticate(username, password))
//		{
//			Profile profile = KeychainHandler.fetch(username, password);
//			// Set the session
//			
//		}
//		else
//		{
//			// Login failed
//			
//		}
		
//		if (session.hasLoggedIn())
//		{
//			// Session is already logged in 
//			// Forward to main page?
//		}

		return View.LOGIN;
	}

}

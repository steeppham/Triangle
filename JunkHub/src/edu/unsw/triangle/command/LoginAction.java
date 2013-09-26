package edu.unsw.triangle.command;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.control.Command;
import edu.unsw.triangle.control.Control;
import edu.unsw.triangle.control.Dispatcher;
import edu.unsw.triangle.model.Credential;
import edu.unsw.triangle.model.Keychain;
import edu.unsw.triangle.service.LoginService;
import edu.unsw.triangle.view.LoginViewHelper;
import edu.unsw.triangle.view.ViewAction;

/**
 * Command to execute login by checking credentials.
 */
public class LoginAction implements Command 
{
	private final static Logger logger = Logger.getLogger(Control.class.getName());
	
	@Override
	public Dispatcher execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("Executing login action");
		Dispatcher dispatcher = null;
		LoginViewHelper loginView = new LoginViewHelper(request);
		
		// Retrieve login parameters
		Credential credential = loginView.getLogin();
		
		Keychain keychain = LoginService.authenticate(credential);
		
		if (keychain.isAuthenticated())
		{
			// Login successful
			// Initialise new session
			// This should go in a SessionManager class
			request.getSession(true).setAttribute("keychain", keychain);
			// Redirect to main command
			dispatcher = new Dispatcher.DispatcherBuilder("main").action(ViewAction.REDIRECT).resource(false).build();

		}
		else
		{
			// Login unsuccessful
			// Return to login page
			loginView.setMessage("Login failed");
			dispatcher = new Dispatcher.DispatcherBuilder(LoginViewHelper.LOGIN_VIEW).action(ViewAction.FORWARD).build();
		}
	
		return dispatcher;
	}

}

package edu.unsw.triangle.core.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.core.Command;
import edu.unsw.triangle.core.Dispatcher;
import edu.unsw.triangle.model.Keychain;
import edu.unsw.triangle.ui.LoginViewHelper;
import edu.unsw.triangle.ui.ViewAction;

/**
 * Command to prepare and display login page. 
 */
public class LoginPageRequest implements Command
{
	/**
	 * Request to display login page.
	 */
	@Override
	public Dispatcher execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		Dispatcher dispatcher = null;
		// Should be done by session object
		Keychain keychain = (Keychain) request.getSession().getAttribute("keychain");
		if (keychain != null)
		{
			// Check if user is already logged in
			if (keychain.isAuthenticated())
			{
				dispatcher =  new Dispatcher.DispatcherBuilder("main").action(ViewAction.REDIRECT).resource(false).build();
			}
		}
		else
		{
			// User has not logged in, display login page
			dispatcher = new Dispatcher.DispatcherBuilder(LoginViewHelper.LOGIN_VIEW).action(ViewAction.FORWARD).build();
		}
		return dispatcher;
	}

}

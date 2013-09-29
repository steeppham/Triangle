package edu.unsw.triangle.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Command;
import edu.unsw.triangle.controller.Dispatcher2;
import edu.unsw.triangle.model.Keychain;
import edu.unsw.triangle.view.LoginViewHelper;
import edu.unsw.triangle.view.ViewAction;

/**
 * Command to prepare and display login page. 
 */
@Deprecated
public class LoginPageRequest implements Command
{
	/**
	 * Request to display login page.
	 */
	@Override
	public Dispatcher2 handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		Dispatcher2 dispatcher = null;
		// Should be done by session object
		Keychain keychain = (Keychain) request.getSession().getAttribute("keychain");
		if (keychain != null)
		{
			// Check if user is already logged in
			if (keychain.isAuthenticated())
			{
				dispatcher =  new Dispatcher2.DispatcherBuilder("main").action(ViewAction.REDIRECT).resource(false).build();
			}
		}
		else
		{
			// User has not logged in, display login page
			dispatcher = new Dispatcher2.DispatcherBuilder(LoginViewHelper.LOGIN_VIEW).action(ViewAction.FORWARD).build();
		}
		return dispatcher;
	}

}

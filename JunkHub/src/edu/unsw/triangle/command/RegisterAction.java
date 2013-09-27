package edu.unsw.triangle.command;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Command;
import edu.unsw.triangle.controller.Dispatcher2;
import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.view.RegisterViewHelper;
import edu.unsw.triangle.view.ValidatorResult;
import edu.unsw.triangle.view.ViewAction;

/**
 * Handles the registration of a user profile from a servlet POST request.
 */
public class RegisterAction implements Command 
{
	final Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public Dispatcher2 handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		// TODO
		// getView(request).
		RegisterViewHelper registerView = new RegisterViewHelper(request);
		Dispatcher2 dispatcher;
		ValidatorResult result = registerView.validate();
		if (result.hasRejected())
		{
			logger.info("Register form rejected due to invalid properties");
			// Invalid form data
			// Forward back to registration page with rejected properties
			registerView.setMessage("Invalid");
			dispatcher = new Dispatcher2.DispatcherBuilder("register.jsp").action(ViewAction.FORWARD).build();
		}	
		else
		{
			logger.info("Register form validated");
			Profile profile = registerView.getProfile();
			// Check profile with database for uniqueness
			// TODO session manager here
			// Profile should not be in attributes here?
			request.getSession().setAttribute("profile", profile);
			// Redirect to confirm page
			dispatcher = new Dispatcher2.DispatcherBuilder("confirm").action(ViewAction.REDIRECT).resource(false).build();
		}
		
		return dispatcher;
	}

}

package edu.unsw.triangle.command;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Command;
import edu.unsw.triangle.controller.Dispatcher2;
import edu.unsw.triangle.model.Keychain;
import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.service.ProfileService;
import edu.unsw.triangle.view.ViewAction;

/**
 * Handles the servlet GET request for the profile page.
 */
public class ProfilePageRequest implements Command {

	final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public Dispatcher2 handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		Dispatcher2 dispatcher = null;
		// TODO session manager
		// Get profile bean from session
		Profile profile = (Profile) request.getSession().getAttribute("profile");
		// Get keychain from session
		Keychain keychain = (Keychain) request.getSession().getAttribute("keychain");
		if (keychain == null)
		{
			// Invalid runtime state
			// throw exception
			logger.severe("Keychain is missing from session");
		}
		if (profile == null)
		{
			// Load from data access object
			logger.info("Retrieving profile details for username: " + keychain.getUsername());
			profile = ProfileService.profile(keychain);
			if (profile == null)
			{
				// could not retrieve user details
				logger.warning("Could not retrieve profile details for username: " + keychain.getUsername());
				// show error
				dispatcher = new Dispatcher2.DispatcherBuilder("error").action(ViewAction.FORWARD).build();
			}
		}

		// Prepare view to display profile information
		request.setAttribute("profile", profile);
		logger.info("Displaying profile page for username: " + profile.getUsername());
		dispatcher = new Dispatcher2.DispatcherBuilder("profile.jsp").action(ViewAction.FORWARD).resource(true).build();
		
		return dispatcher;
	}

}

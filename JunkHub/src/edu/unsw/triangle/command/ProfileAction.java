package edu.unsw.triangle.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Command;
import edu.unsw.triangle.controller.Dispatcher2;

/**
 * Handles the servlet POST request for updating profile 
 * information from the profile page.
 */
public class ProfileAction implements Command {

	@Override
	public Dispatcher2 handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		// Validate profile data
		// Profile profileUpdate = ProfileViewHelper.getProfileUpdates()
		// ValidatorResult result = Validator.profile(profile)
		// if (result.hasErrors)
		// {
		/**
		 * report errors to view
		 * profileViewHelper.report(result)
		 * 
		 * dispatcher.dispatchbuilder("profile").action(ViewAction.FORWARD).build()
		 * }
		 * else
		 * {
		 *  no errors
		 * save changes to data layer
		 * ProfileService.update(profile)
		 * redirect to profile with message?
		 * dispatcher.dispatchbulder("profile").action(ViewAction.REDIRECT).build()
		 * }
		 */
		
		return null;
	}

}

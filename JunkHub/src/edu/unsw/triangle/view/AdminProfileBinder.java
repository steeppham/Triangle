package edu.unsw.triangle.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.util.Errors;

public class AdminProfileBinder implements RequestBinder {

	@Override
	public Object bindAndValidate(HttpServletRequest request, Errors errors) 
	{
		// Retrieve list of profiles selected on form
		String[] usernameValues = request.getParameterValues("suspend.profiles");
		List<String> usernames = new ArrayList<String>();
		if (usernameValues != null)
		{
			for (String username : usernameValues)
			{
				usernames.add(username);
			}
		}
		return usernames;
	}
}

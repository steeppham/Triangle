package edu.unsw.triangle.web;

import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Controller;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.model.WebSession;

public class ProfileRequestController implements Controller 
{
	private final Logger logger = Logger.getLogger(ProfileRequestController.class.getName());
	
	@Override
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		// Check session details
		WebSession websession = (WebSession) request.getSession().getAttribute("websession");
		if (websession == null)
		{
			throw new ServletException("web session is missing");
		}
		
		// TODO handle error updating profile details
		Profile profile = (Profile) request.getAttribute("profile");
		Profile profileError = (Profile) request.getAttribute("profile.error");
		if (profile == null || profileError != null)
		{
			// Retrieve profile from web session
			profile = websession.getProfile();
			if (profile == null)
			{
				logger.warning("profile missing from web session");
			}
		}
		
		ModelView modelView = new ModelView(getFormView()).forward().addModel("profile", profile);
		return modelView;
	}

	@Override
	public String getFormView() 
	{
		return "profile.view";
	}
}

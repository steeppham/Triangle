package edu.unsw.triangle.web;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Controller;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.model.WebSession;

public class ProfileRequestController implements Controller 
{

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
			// Retrieve profile details
			// Service here...
			profile = new Profile();
			profile.setUsername("stephen");
			profile.setDob(new Date());
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

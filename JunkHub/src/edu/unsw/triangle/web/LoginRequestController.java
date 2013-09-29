package edu.unsw.triangle.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Controller;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.WebSession;

public class LoginRequestController implements Controller
{
	private final Logger logger = Logger.getLogger(LoginRequestController.class.getName());

	@Override
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("Handling login request");
		logger.info("Forward view to login");
		
		// Check if user is already logged in
		WebSession websession = (WebSession) request.getSession().getAttribute("websession");
		if (websession != null)
		{
			logger.info("User '" + websession.getUsername() + "' is already logged in");
			// Forward to main
			return new ModelView("main").redirect();
		}
		
		return new ModelView(getFormView()).forward();
	}

	@Override
	public String getFormView() 
	{
		return "login.view";
	}
}

package edu.unsw.triangle.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Controller;
import edu.unsw.triangle.controller.ModelView;

public class LogoutRequestController implements Controller 
{
	private final Logger logger = Logger.getLogger(LogoutRequestController.class.getName());

	@Override
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("logging out from websession");
		request.getSession().invalidate();
		ModelView modelView = new ModelView(getFormView()).forward();
		return modelView;
	}

	@Override
	public String getFormView() 
	{
		return "logout.view";
	}

}

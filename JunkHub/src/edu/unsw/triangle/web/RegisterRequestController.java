package edu.unsw.triangle.web;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.AbstractRequestController;
import edu.unsw.triangle.controller.Controller;
import edu.unsw.triangle.controller.ModelView;

public class RegisterRequestController extends AbstractRequestController 
{

	private final Logger logger = Logger.getLogger(LoginRequestController.class.getName());
	
	@Override
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{	
		logger.info("Handling register request");
		logger.info("Forward view to register page");
		return new ModelView(getFormView()).forward();
	}

	@Override
	public String getFormView() 
	{
		return "register.view";
	}

	@Override
	public String[] getRedirectObjects() {
		return new String[] {"registerSuccess"};
	}

}

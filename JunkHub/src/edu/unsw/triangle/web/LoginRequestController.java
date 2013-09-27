package edu.unsw.triangle.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Controller;
import edu.unsw.triangle.controller.ModelView;

public class LoginRequestController implements Controller
{
	private final Logger logger = Logger.getLogger(LoginRequestController.class.getName());

	@Override
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("Handling login request");
		logger.info("Forward view to login");
		return new ModelView("login.view").forward();
	}

}

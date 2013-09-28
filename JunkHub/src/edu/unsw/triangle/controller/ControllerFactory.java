package edu.unsw.triangle.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.web.LoginFormController;
import edu.unsw.triangle.web.LoginRequestController;

/**
 * Factory for creating concrete command objects based on request parameters.
 */
public class ControllerFactory 
{
	// TODO this constant should come from the web.xml
	public static final String CONTROLLER = "controller";
	public static final String REGISTER = "register";
	public static final String LOGIN = "login";
	public static final String MAIN = "main";
	private static final String CONFIRM = "confirm";
	private static final String SEARCH = "search";
	private static final String PROFILE = "profile";
	
	private final static Map<String, Controller> mapping;
	
	private final static Logger logger = Logger.getLogger(ControllerFactory.class.getName());
	
	// Create mapping for request commands and the associated command handler
	static 
	{
		mapping = new HashMap<String, Controller>();
		mapping.put("GET/login", new LoginRequestController());
		mapping.put("POST/login", new LoginFormController());
//		mapping.put("POST/" + LOGIN, new LoginAction());
//		mapping.put("GET/" + REGISTER, new RegisterPageRequest());
//		mapping.put("POST/" + REGISTER, new RegisterAction());
//		mapping.put("GET/" + MAIN, new MainPageRequest());
//		mapping.put("GET/" + CONFIRM, new ConfirmPageRequest());
//		mapping.put("GET/" + SEARCH, new SearchAction());
//		mapping.put("GET/" + PROFILE, new ProfilePageRequest());
//		mapping.put("POST/" + PROFILE, new ProfileAction());
	}
	
	/**
	 * Creates a concrete command object based on the parameters of the http request.
	 * @param request
	 * @return Concrete command object.
	 */
	public static Controller create(HttpServletRequest request)
	{
		logger.info("Controller hanlder: " + request.getMethod() + request.getPathInfo());
		return mapping.get(request.getMethod() + request.getPathInfo());
	}

}

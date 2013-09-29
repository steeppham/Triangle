package edu.unsw.triangle.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.web.LoginFormController;
import edu.unsw.triangle.web.LoginRequestController;
import edu.unsw.triangle.web.MainRequestController;
import edu.unsw.triangle.web.ProfileFormController;
import edu.unsw.triangle.web.ProfileRequestController;
import edu.unsw.triangle.web.RegisterFormController;
import edu.unsw.triangle.web.RegisterRequestController;
import edu.unsw.triangle.web.SearchFormController;

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
		mapping.put("GET/register", new RegisterRequestController());
		mapping.put("POST/register", new RegisterFormController());
		mapping.put("GET/main", new MainRequestController());
		mapping.put("GET/search", new SearchFormController());
		mapping.put("GET/profile", new ProfileRequestController());
		mapping.put("POST/profile", new ProfileFormController());
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
	 * @throws ServletException 
	 */
	public static Controller create(HttpServletRequest request) throws ServletException
	{
		String url = request.getMethod() + request.getPathInfo();
		if (!mapping.containsKey(url))
		{
			logger.warning("request url: " + url + " is not mapped");
			throw new ServletException("Request url: " + url + " is not mapped");
		}
		return mapping.get(url);
	}

}

package edu.unsw.triangle.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.web.AdminItemFormController;
import edu.unsw.triangle.web.AdminProfileFormController;
import edu.unsw.triangle.web.AdminRequestController;
import edu.unsw.triangle.web.ConfirmRequestController;
import edu.unsw.triangle.web.ItemFormController;
import edu.unsw.triangle.web.ItemPendingFormController;
import edu.unsw.triangle.web.ItemRequestController;
import edu.unsw.triangle.web.LoginFormController;
import edu.unsw.triangle.web.LoginRequestController;
import edu.unsw.triangle.web.LogoutRequestController;
import edu.unsw.triangle.web.MainRequestController;
import edu.unsw.triangle.web.ProfileFormController;
import edu.unsw.triangle.web.ProfileRequestController;
import edu.unsw.triangle.web.RegisterFormController;
import edu.unsw.triangle.web.RegisterRequestController;
import edu.unsw.triangle.web.SearchFormController;
import edu.unsw.triangle.web.SellFormController;
import edu.unsw.triangle.web.SellRequestController;

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
		mapping.put("GET/sell", new SellRequestController());
		mapping.put("POST/sell", new SellFormController());
		mapping.put("GET/item", new ItemRequestController());
		mapping.put("POST/item", new ItemFormController());
		mapping.put("POST/item.pending", new ItemPendingFormController());
		mapping.put("GET/logout", new LogoutRequestController());
		mapping.put("GET/admin", new AdminRequestController());
		mapping.put("POST/admin.profile", new AdminProfileFormController());
		mapping.put("POST/admin.item", new AdminItemFormController());
		mapping.put("GET/confirm", new ConfirmRequestController());
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

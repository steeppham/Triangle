package edu.unsw.triangle.core;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Factory for creating concrete command objects based on request parameters.
 */
public class CommandFactory 
{
	private static Map<String, Command> commands = new HashMap<String, Command>();
	
	private final static Logger logger = Logger.getLogger(CommandFactory.class.getName());
	
	// Create mapping for request commands and the associated command handler
	static 
	{
		commands.put("GET/login", new LoginHandler());
	}
	
	/**
	 * Creates a concrete command object based on the parameters of the http request.
	 * @param request
	 * @return Concrete command object.
	 */
	public static Command create(HttpServletRequest request)
	{
		logger.info("Command request: " + request.getMethod() + request.getPathInfo());
		return commands.get(request.getMethod() + request.getPathInfo());
	}

}

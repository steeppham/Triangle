package edu.unsw.triangle.core;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.core.command.LoginCommand;
import edu.unsw.triangle.core.command.RegisterCommand;

/**
 * Factory for creating concrete command objects based on request parameters.
 */
public class CommandFactory 
{
	// TODO this constant should come from the web.xml
	public static final String CONTROLLER = "controller";
	public static final String REGISTER = "register";
	public static final String LOGIN = "login";
	
	private static Map<String, Command> commands = new HashMap<String, Command>();
	
	private final static Logger logger = Logger.getLogger(CommandFactory.class.getName());
	
	// Create mapping for request commands and the associated command handler
	static 
	{
		commands.put("GET/" + LOGIN, new LoginCommand());
		commands.put("GET/" + REGISTER, new RegisterCommand());
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

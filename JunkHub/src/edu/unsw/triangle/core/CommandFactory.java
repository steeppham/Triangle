package edu.unsw.triangle.core;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.core.command.ConfirmPageRequest;
import edu.unsw.triangle.core.command.LoginAction;
import edu.unsw.triangle.core.command.LoginPageRequest;
import edu.unsw.triangle.core.command.MainPageRequest;
import edu.unsw.triangle.core.command.ProfileAction;
import edu.unsw.triangle.core.command.ProfilePageRequest;
import edu.unsw.triangle.core.command.RegisterAction;
import edu.unsw.triangle.core.command.RegisterPageRequest;
import edu.unsw.triangle.core.command.SearchAction;

/**
 * Factory for creating concrete command objects based on request parameters.
 */
public class CommandFactory 
{
	// TODO this constant should come from the web.xml
	public static final String CONTROLLER = "controller";
	public static final String REGISTER = "register";
	public static final String LOGIN = "login";
	public static final String MAIN = "main";
	private static final String CONFIRM = "confirm";
	private static final String SEARCH = "search";
	private static final String PROFILE = "profile";
	
	private static Map<String, Command> commands = new HashMap<String, Command>();
	
	private final static Logger logger = Logger.getLogger(CommandFactory.class.getName());
	
	// Create mapping for request commands and the associated command handler
	static 
	{
		commands.put("GET/" + LOGIN, new LoginPageRequest());
		commands.put("POST/" + LOGIN, new LoginAction());
		commands.put("GET/" + REGISTER, new RegisterPageRequest());
		commands.put("POST/" + REGISTER, new RegisterAction());
		commands.put("GET/" + MAIN, new MainPageRequest());
		commands.put("GET/" + CONFIRM, new ConfirmPageRequest());
		commands.put("GET/" + SEARCH, new SearchAction());
		commands.put("GET/" + PROFILE, new ProfilePageRequest());
		commands.put("POST/" + PROFILE, new ProfileAction());
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

package edu.unsw.triangle.core;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main controller for all servlet requests. 
 */
public class Control extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	
	private final static Logger logger = Logger.getLogger(Control.class.getName());
	
	/**
	 * Default constructor
	 */
	public Control()
	{
		super();
	}

	/**
	 * Perform servlet initialisation.
	 */
	@Override
	public void init() throws ServletException 
	{
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * Perform both GET and POST requests.
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			Command command = CommandFactory.create(request);
			Dispatcher dispatcher = command.execute(request, response);
			
			switch (dispatcher.getAction())
			{
				case FORWARD:
					// Forward view
					request.getRequestDispatcher(dispatcher.getUri()).forward(request, response);
					break;
				case REDIRECT:
					// Redirect to view
					response.sendRedirect(dispatcher.getUri());
					break;
				default:
					// Invalid view action
					// throw exception
			}
		}
		catch (Exception e)
		{
			// Issue with relative path when given <url>/control
			Dispatcher dispatcher = new Dispatcher.DispatcherBuilder("error.jsp").build();
			request.getRequestDispatcher(dispatcher.getUri()).forward(request, response);
			//response.sendRedirect(dispatcher.getUri());
			logger.severe("Request operation failed reason: " + e.getMessage());
			//throw new ServletException("Request operation failed.", e);
		}
	}

}

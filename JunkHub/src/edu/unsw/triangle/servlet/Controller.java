package edu.unsw.triangle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main controller  
 */
public class Controller extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public Controller()
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
			String view = command.execute(request, response);
			
			// Forward view to client
			request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(request, response);
            
			// Redirect to another view?
			//response.sendRedirect(view);
		}
		catch (Exception e)
		{
			throw new ServletException("Request operation failed.", e);
		}
	}

}

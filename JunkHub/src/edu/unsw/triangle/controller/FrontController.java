package edu.unsw.triangle.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Front controller for all servlet requests. Delegates to controller implementations according to request.
 */
public class FrontController extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	
	private final static Logger logger = Logger.getLogger(FrontController.class.getName());
	
	/**
	 * Default constructor
	 */
	public FrontController()
	{
		super();
	}

	/**
	 * Perform servlet initialisation.
	 */
	@Override
	public void init() throws ServletException 
	{
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
			Controller controller = ControllerFactory.create(request);
			ModelView modelView = controller.handleRequest(request, response);
			// Intermediate steps here...
			bindModelView(request, modelView);
			Dispatcher.create(request, response).doDispatch(modelView);
			
		}
		catch (Exception e)
		{
			// Show error page
			ModelView errorView = new ModelView("error.view").forward();
			Dispatcher.create(request, response).doDispatch(errorView);
			logger.severe("Request operation failed reason: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	protected void bindModelView(HttpServletRequest request, ModelView modelView)
	{
		for (String name : modelView.modelSet())
		{
			request.setAttribute(name, modelView.getModel(name));
		}
		
		HttpSession session = request.getSession();
		for (String name : modelView.sessionModelSet())
		{
			session.setAttribute(name, modelView.getSessionModel(name));
		}
	}

}

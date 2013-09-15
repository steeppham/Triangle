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
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}

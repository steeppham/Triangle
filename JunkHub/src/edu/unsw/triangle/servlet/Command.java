package edu.unsw.triangle.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Defines the implementation of delegated actions from a web request.
 */
public interface Command 
{
	/**
	 * Execute the command for the servlet request and return the appropriate view.
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}

package edu.unsw.triangle.view;

import javax.servlet.http.HttpServletRequest;

/**
 * Abstract class representing view pages. 
 */
public abstract class ViewHelper
{
	protected HttpServletRequest request;
	
	public ViewHelper(HttpServletRequest request)
	{
		this.request = request;
	}
}

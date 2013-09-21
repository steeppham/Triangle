package edu.unsw.triangle.core;

import javax.servlet.http.HttpServletRequest;

public abstract class CommandAbstract implements Command
{
	// Authentication?
	private HttpServletRequest request = null;
	
	public CommandAbstract(HttpServletRequest request)
	{
		
	}
	
	public Object getSessionAttribute(String key)
	{
		return null;
	}
	
	public void setSessionAttribute(String key, Object value)
	{
		
	}

}

package edu.unsw.triangle.view;

import java.util.HashMap;
import java.util.Map;

public class ViewResolver 
{
	private final static Map<String, String> mapping;
	
	static
	{
		mapping = new HashMap<String, String>();
		mapping.put("login.view", "/WEB-INF/login.jsp");
		mapping.put("login", "login");
		mapping.put("error.view", "/WEB-INF/error.jsp");
		mapping.put("register.view", "/WEB-INF/register.jsp");
	}
	
	public String resolve(String name)
	{
		return mapping.get(name);
	}

}

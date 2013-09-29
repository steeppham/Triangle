package edu.unsw.triangle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.view.ViewAction;

/**
 * Builds the descriptor used for servlet dispatching. 
 */
public class Dispatcher2 
{
	private String uri;
	private ViewAction action;
	private boolean isResource;
	private final String WEB_INF = "/WEB-INF/";
	
	private Dispatcher2(DispatcherBuilder builder)
	{
		this.uri = builder.name + builder.parameters.toString();
		if (builder.isResource)
			uri = WEB_INF + uri;
		this.action = builder.action;
	}
	
	public String getUri()
	{
		return uri;
	}
	
	public ViewAction getAction()
	{
		return action;
	}
	
	public boolean isResource()
	{
		return isResource;
	}
	
	public static class DispatcherBuilder
	{
		private StringBuilder parameters = new StringBuilder();
		private String name;
		private ViewAction action;
		private boolean isResource = true;
		
		public DispatcherBuilder(String name)
		{
			this.name = name;
		}
		
		public DispatcherBuilder parameter(String name, String value)
		{
			if (parameters.length() == 0)
				parameters.append("?");
			else
				parameters.append("%");
			parameters.append(name).append("=").append(value);
			return this;
		}
		
		public DispatcherBuilder action(ViewAction action)
		{
			this.action = action;
			return this;
		}
		
		public DispatcherBuilder resource(Boolean isResource)
		{
			this.isResource = isResource;
			return this;
		}
		
		public Dispatcher2 build()
		{
			return new Dispatcher2(this);
		}
	}

	public static Dispatcher2 create(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}

}
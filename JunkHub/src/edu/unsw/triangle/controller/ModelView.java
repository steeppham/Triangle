package edu.unsw.triangle.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.unsw.triangle.model.WebSession;

public class ModelView 
{
	public enum ResponseAction
	{
		FORWARD,
		REDIRECT
	}
	
	private String viewName;
	private ResponseAction action = ResponseAction.FORWARD;
	private final Map<String, Object> modelMap = new HashMap<String, Object>();
	private final Map<String, Object> sessionModelMap = new HashMap<String, Object>();
	private final Map<String, String> parameterMap =  new HashMap<String, String>();
	
	public ModelView(String viewName) 
	{
		this.viewName = viewName;
	}

	public ModelView forward() 
	{
		action = ResponseAction.FORWARD;
		return this;
	}

	public String getViewName() 
	{
		return viewName;
	}

	public ResponseAction getAction() 
	{
		return action;
	}

	public ModelView redirect() 
	{
		action = ResponseAction.REDIRECT;
		return this;
	}
	
	public ModelView addModel(String name, Object model)
	{
		modelMap.put(name, model);
		return this;
	}

	public Set<String> modelSet() 
	{
		return modelMap.keySet();
	}

	public Object getModel(String name) 
	{
		return modelMap.get(name);
	}

	public ModelView addSessionModel(String name, Object model) 
	{
		sessionModelMap.put(name, model);
		return this;	
	}

	public Object getSessionModel(String name) 
	{
		return sessionModelMap.get(name);
	}

	public Set<String> sessionModelSet() 
	{
		return sessionModelMap.keySet();
	}
	
	public ModelView addParameter(String name, String value)
	{
		parameterMap.put(name, value);
		return this;
	}
	
	public Set<String> getParameterSet()
	{
		return parameterMap.keySet();
	}
	
	public String getParameter(String name)
	{
		return parameterMap.get(name);
	}
}

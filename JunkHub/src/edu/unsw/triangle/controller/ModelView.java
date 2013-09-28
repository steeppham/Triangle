package edu.unsw.triangle.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

}

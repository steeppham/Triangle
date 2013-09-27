package edu.unsw.triangle.controller;

public class ModelView 
{
	public enum ResponseAction
	{
		FORWARD,
		REDIRECT
	}
	
	private String viewName;
	private ResponseAction action = ResponseAction.FORWARD;
	
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

}

package edu.unsw.triangle.model;

import java.io.Serializable;

public class Query implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String title;

	public String getFindByTitle() 
	{
		return title;
	}

	public void setFindByTitle(String query) 
	{
		this.title = query;
	}
}

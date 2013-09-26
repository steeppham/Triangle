package edu.unsw.triangle.view;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.ItemCollection;

public class MainViewHelper extends ViewHelper
{
	public final static String MAIN_VIEW = "main.jsp";
	public final static String PARAMETER_QUERY = "query";
	public final static String ATTRIBUTE_RESULT = "result";
	public final static String BEAN_PROFILE = "profile";
	

	public MainViewHelper(HttpServletRequest request) 
	{
		super(request);
	}

	/** 
	 * Return the query string 
	 */
	public String getQuery() 
	{
		return (String)request.getParameter(PARAMETER_QUERY);
	}

	public void setSearchResult(ItemCollection results)
	{
		request.setAttribute(ATTRIBUTE_RESULT, results);
	}
}

package edu.unsw.triangle.ui;

import javax.servlet.http.HttpServletRequest;

public class MainViewHelper extends ViewHelper
{
	public final static String MAIN_VIEW = "main.jsp";
	public final static String ATTRIBUTE_MESSAGE = "message";
	public final static String PARAMETER_USERNAME = "username";
	public final static String PARAMETER_PASSWORD = "password";
	public final static String BEAN_PROFILE = "profile";
	

	public MainViewHelper(HttpServletRequest request) 
	{
		super(request);
	}


}

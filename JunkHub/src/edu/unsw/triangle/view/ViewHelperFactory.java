package edu.unsw.triangle.view;

import javax.servlet.http.HttpServletRequest;

public class ViewHelperFactory 
{
	HttpServletRequest request;
	
	public ViewHelperFactory(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public MainViewHelper main()
	{
		return new MainViewHelper(request);
	}
}

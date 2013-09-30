package edu.unsw.triangle.view;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.util.Errors;

public interface RequestBinder 
{
	public Object bindAndValidate(HttpServletRequest request, Errors errors);
}

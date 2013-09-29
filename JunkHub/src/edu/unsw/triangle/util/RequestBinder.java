package edu.unsw.triangle.util;

import javax.servlet.http.HttpServletRequest;

public interface RequestBinder 
{
	public Object bindAndValidate(HttpServletRequest request, Errors errors);
}

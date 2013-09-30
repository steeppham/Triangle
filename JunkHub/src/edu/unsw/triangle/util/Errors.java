package edu.unsw.triangle.util;

import java.util.HashMap;
import java.util.Map;

//TODO merge with messages class
public class Errors 
{
	private final Map<String, String> errors = new HashMap<String, String>();
	
	public boolean hasErrors()
	{
		return !errors.isEmpty();
	}
	
	public String getErrorMessage(String field)
	{
		return errors.get(field);
	}
	
	public Errors rejectValue(String field, String message)
	{
		errors.put(field, message);
		return this;
	}

}

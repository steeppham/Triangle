package edu.unsw.triangle.util;

import java.util.HashMap;
import java.util.Map;

public class Messages 
{
	private final Map<String, String> messages = new HashMap<String, String>();
	
	public boolean hasMessage()
	{
		return !messages.isEmpty();
	}
	
	public String getMessage(String field)
	{
		return messages.get(field);
	}
	
	public Messages add(String field, String message)
	{
		messages.put(field, message);
		return this;
	}

}

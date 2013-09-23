package edu.unsw.triangle.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ValidatorResult 
{
	private Map<String, String> rejectedValues = new HashMap<String, String>();
	
	public void reject(String name, String reason)
	{
		rejectedValues.put(name, reason);
	}
	
	public void rejectNullOrEmpty(String name)
	{
		reject(name, "Value is null or empty");
	}
	
	public void rejectInvalidFormat(String name)
	{
		reject(name, "Invalid format");
	}
	
	public boolean hasRejected()
	{
		if (rejectedValues.isEmpty())
			return false;
		else
			return true;
	}
	
	public Iterator<Entry<String, String>> iterator()
	{
		return rejectedValues.entrySet().iterator();
	}

}

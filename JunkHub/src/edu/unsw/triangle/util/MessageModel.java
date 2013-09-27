package edu.unsw.triangle.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MessageModel 
{
	private Map<String, String> messages = null;
	
	public MessageModel()
	{
		messages = new HashMap<String, String>();
	}
	
	public MessageModel add(String name, String value)
	{
		messages.put(name, value);
		return this;
	}
	
	public int getSize()
	{
		return messages.size();
	}
	
	public String getValueOf(String name)
	{
		return messages.get(name);
	}
	
	public Set<String> getNames()
	{
		return messages.keySet();
	}

}

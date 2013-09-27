package edu.unsw.triangle.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Creation class for the various DAO services.
 */
public class ServiceFactory 
{
	private static ServiceFactory serviceFactory;
	private static final  Map<String, Object> services;
	
	// Define hashmap of services
	static 
	{
		services = new HashMap<String, Object>();
		services.put("search", new SearchService());
	}
	
	private ServiceFactory()
	{
		
	}

	public static ServiceFactory getInstance() 
	{
		if (serviceFactory == null)
		{
			serviceFactory = new ServiceFactory();
		}
		return serviceFactory;
	}
	
	public SearchService search()
	{
		return (SearchService) services.get("search");
	}
	

}

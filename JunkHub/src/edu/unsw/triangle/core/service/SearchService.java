package edu.unsw.triangle.core.service;

import edu.unsw.triangle.model.ItemCollection;

public class SearchService 
{

	/**
	 * Search data repository for item query
	 * @param query Search item query
	 * @return ItemList containing the results of the query
	 */
	public static ItemCollection search(String query) 
	{
		// TODO DAO operation here
		// search database table for item title given by query?
		// return results and add them to a collection
		
		ItemCollection result = new ItemCollection();
		return result;
	}

}

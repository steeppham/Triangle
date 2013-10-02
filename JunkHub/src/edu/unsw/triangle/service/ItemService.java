package edu.unsw.triangle.service;

import java.sql.SQLException;

import edu.unsw.triangle.data.ConnectionManager;
import edu.unsw.triangle.data.DataSourceException;
import edu.unsw.triangle.data.DerbyDaoManager;
import edu.unsw.triangle.model.Item;

public class ItemService 
{
	public static Item findItemById(int id) throws SQLException, DataSourceException
	{
		Item item = null;
		DerbyDaoManager daoManager = null;
		try
		{
			daoManager = new DerbyDaoManager(ConnectionManager.getInstance());
			item = daoManager.getItemDao().findById(id);
		}
		finally
		{
			if(daoManager != null)
				daoManager.close();
		}
		
		return item;
	}
	
	public static void addNewItem(Item item) throws SQLException, DataSourceException
	{
		DerbyDaoManager daoManager = null;
		try
		{
			daoManager = new DerbyDaoManager(ConnectionManager.getInstance());
			daoManager.getItemDao().add(item);
		}
		finally
		{
			if(daoManager != null)
				daoManager.close();
		}
	}

}

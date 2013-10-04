package edu.unsw.triangle.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import edu.unsw.triangle.data.ConnectionManager;
import edu.unsw.triangle.data.DataSourceException;
import edu.unsw.triangle.data.DerbyDaoManager;
import edu.unsw.triangle.model.Item;

public class ItemService 
{
	private static final Logger logger = Logger.getLogger(ItemService.class.getName());
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

	public static List<Item> findAllItems() throws DataSourceException, SQLException 
	{
		List<Item> items = new ArrayList<Item>();
		DerbyDaoManager daoManager = null;
		try
		{
			daoManager = new DerbyDaoManager(ConnectionManager.getInstance());
			List<Integer> itemIds = daoManager.getItemDao().getAllIds();
			for (int id : itemIds)
			{
				Item item = daoManager.getItemDao().findById(id);
				if (item != null)
				{
					items.add(item);
				}
				else
				{
					logger.warning("item id " + id + " could not be retrieved from repository");
				}
			}
		}
		finally
		{
			if(daoManager != null)
				daoManager.close();
		}
		return items;
	}

}

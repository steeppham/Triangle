package edu.unsw.triangle.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import edu.unsw.triangle.data.ConnectionManager;
import edu.unsw.triangle.data.DataSourceException;
import edu.unsw.triangle.data.DerbyDaoManager;
import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.model.Item.ItemStatus;
import edu.unsw.triangle.model.Profile;

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
	
	public static List<Item> findAllActiveItems()
	{
		return null;
	}

	public static void suspendItemsOfUsers(List<String> usernames) throws DataSourceException, SQLException 
	{
		// Short circuit if there is nothing to process
		if (usernames == null || usernames.isEmpty())
		{
			return;
		}
		DerbyDaoManager daoManager = null;
		try
		{
			daoManager = new DerbyDaoManager(ConnectionManager.getInstance());
			for (String username : usernames)
			{
				logger.info("halt items of user: " + username);
				List<Item> items = daoManager.getItemDao().findByOwner(username);
				for (Item item : items)
				{
					daoManager.getItemDao().updateItemStatus(item.getId(), ItemStatus.NOT_ACTIVE);
					logger.info("item: " + item.getTitle() + "halted owned by user:" + username);
					
					// Notify owner that item has been suspended
					Profile owner = daoManager.getProfileDao().findByUsername(item.getOwner());
					NotificationService.notifyItemOwnerSuspend(owner.getEmail(), item);
				}
			}
		}
		finally
		{
			if(daoManager != null)
				daoManager.close();
		}
	}

	public static void suspendItem(List<Integer> itemsId) throws DataSourceException, SQLException 
	{
		// Short circuit if there is nothing to process
		if (itemsId == null || itemsId.isEmpty())
		{
			return;
		}
		DerbyDaoManager daoManager = null;
		try
		{
			daoManager = new DerbyDaoManager(ConnectionManager.getInstance());
			for (int itemId : itemsId)
			{
				daoManager.getItemDao().updateItemStatus(itemId, ItemStatus.NOT_ACTIVE);
				logger.info("item id: " + itemId + " suspended");
				
				// Notify owner that item has been suspended
				Item item = daoManager.getItemDao().findById(itemId);
				Profile owner = daoManager.getProfileDao().findByUsername(item.getOwner());
				NotificationService.notifyItemOwnerSuspend(owner.getEmail(), item);
			}
		}
		finally
		{
			if(daoManager != null)
				daoManager.close();
		}
		
	}

}

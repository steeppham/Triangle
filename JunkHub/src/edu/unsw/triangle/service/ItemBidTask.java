package edu.unsw.triangle.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import edu.unsw.triangle.data.ConnectionManager;
import edu.unsw.triangle.data.DerbyDaoManager;
import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.model.Item.ItemStatus;
import edu.unsw.triangle.model.Profile;

public class ItemBidTask  implements Runnable
{
	private final static Logger logger = Logger.getLogger(ItemBidTask.class.getName());
    
	@Override
    public void run() 
	{
        logger.info("Running item bid check...");

		DerbyDaoManager daoManager = null;
		try
		{
			daoManager = new DerbyDaoManager(ConnectionManager.getInstance());
			List<Item> activeItems = daoManager.getItemDao().findItemsByStatus(ItemStatus.ACTIVE);
			List<Item> expiredItems = new ArrayList<Item>();
			
			// Filter items that have expired but is labelled active
			for (Item item : activeItems)
			{
				if (item.getTimeLeft() < 0)
					expiredItems.add(item);
			}
			logger.info("Found " + expiredItems.size() + " expired items");
			
			// Check item bid condition
			for (Item item : expiredItems)
			{
				// Retrieve owner of item profile
				Profile owner = daoManager.getProfileDao().findByUsername(item.getOwner());
				
				if (item.getBid() > item.getReserve())
				{
					// Bid successful
					item.setStatus(ItemStatus.SOLD);
					logger.info("Item '" + item.getTitle() + "' is sold");
					// Notify owner
					NotificationService.notify(owner.getEmail(), "Item Sold!", "You item has sold");
					// Notify bidder
					Profile bidder = daoManager.getProfileDao().findByUsername(item.getBidder());
					NotificationService.notify(bidder.getEmail(), "You have won!", "You have successfuly bidded for item");
				}
				else if (item.getBid() > item.getStart())
				{
					// Bid did not make reserve
					item.setStatus(ItemStatus.PENDING);
					// Notify owner and bidder
					logger.info("Item '" + item.getTitle() + "' is pending");
				}
				else
				{
					// No bids
					item.setStatus(ItemStatus.UNSOLD);
					// Notify owner and bidder
					logger.info("Item '" + item.getTitle() + "' is unsold");
				}
				// Update repository
				daoManager.getItemDao().updateItemStatus(item.getId(), item.getStatus());
			}
			
		}
		catch (Exception e)
		{
			logger.severe("Error running scheduled task reason " + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			if(daoManager != null)
			try
			{
				daoManager.close();
			}
			catch (SQLException e)
			{
				logger.severe("Error closing DAOManager reason " + e.getMessage());
				e.printStackTrace();
			}
		}
    }

}

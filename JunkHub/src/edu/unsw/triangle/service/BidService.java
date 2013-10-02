package edu.unsw.triangle.service;

import java.sql.SQLException;

import edu.unsw.triangle.data.ConnectionManager;
import edu.unsw.triangle.data.DataSourceException;
import edu.unsw.triangle.data.DerbyDaoManager;
import edu.unsw.triangle.model.Bid;

public class BidService 
{
	public static void updateItemBid(Bid bid) throws SQLException, DataSourceException
	{
		DerbyDaoManager daoManager = null;
		try
		{
			daoManager = new DerbyDaoManager(ConnectionManager.getInstance());
			daoManager.getItemDao().updateItemBid(bid);
		}
		finally
		{
			if(daoManager != null)
				daoManager.close();
		}
	}

}

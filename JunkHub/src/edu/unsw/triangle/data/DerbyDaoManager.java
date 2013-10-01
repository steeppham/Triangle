package edu.unsw.triangle.data;

import java.sql.SQLException;

public class DerbyDaoManager extends AbstractDaoFactory
{
	private ProfileDao profileDao;
	private ItemDao itemDao;
	
	private DerbyDaoManager(ConnectionManager connectionManager) 
	{ 
		super(connectionManager);
	}

	@Override
	public ProfileDao getProfileDao() throws SQLException 
	{
		if (profileDao == null)
			profileDao = new ProfileDaoImpl(connectionManager.getConnection());
		return profileDao;
	}

	@Override
	public ItemDao getItemDao() throws SQLException
	{
		if (itemDao == null)
			itemDao = new ItemDaoImpl(connectionManager.getConnection());
		return itemDao;
	}
	
	public void close() throws SQLException
	{
		connectionManager.closeConnection();
	}
}

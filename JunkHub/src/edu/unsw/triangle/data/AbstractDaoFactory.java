package edu.unsw.triangle.data;

import java.sql.SQLException;

public abstract class AbstractDaoFactory 
{
	protected ConnectionManager connectionManager;
	
	public AbstractDaoFactory(ConnectionManager connectionManager)
	{
		this.connectionManager = connectionManager;
	}
	
	public abstract ProfileDao getProfileDao() throws SQLException;

	public abstract ItemDao getItemDao() throws SQLException;
}

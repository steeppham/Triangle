package edu.unsw.triangle.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * A connection pool manager for handling connections to a database.
 */
public class ConnectionManager 
{
	private static ConnectionManager connectionManager = null;
	
	private DataSource datasource;
	private Connection connection;
	private final Logger logger = Logger.getLogger(ConnectionManager.class.getName());
	
	public static ConnectionManager getInstance() throws DataSourceException
	{
		if (connectionManager == null)
		{
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}
	
	private ConnectionManager() throws DataSourceException
	{
		try
		{
			// Get DataSource
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			datasource = (DataSource) envContext.lookup("jdbc/junkdb");
		}
		catch (NamingException e)
		{
			logger.severe("cannot locate database");
			throw new DataSourceException("cannot locate database", e);
		}
	}
	
	public Connection getConnection() throws SQLException
	{
		if (connection == null || connection.isClosed())
		{
			connection = datasource.getConnection();
		}
		return connection;
	}
	
	public void closeConnection() throws SQLException
	{
		if (connection != null && !connection.isClosed())
		{
			connection.close();
		}
	}

}

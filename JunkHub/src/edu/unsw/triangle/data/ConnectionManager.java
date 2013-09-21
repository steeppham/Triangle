package edu.unsw.triangle.data;

public class ConnectionManager 
{
	private static ConnectionManager connection = null;
	
	public static ConnectionManager getInstance()
	{
		if (connection == null)
		{
			connection = new ConnectionManager();
		}
		return connection;
	}
	
	public void open()
	{
		
	}
	
	public void closed()
	{
		
	}

}

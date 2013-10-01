package edu.unsw.triangle.data;

import java.sql.Connection;

public abstract class GenericDao 
{
	protected Connection connection;
	
	public GenericDao(Connection connection)
	{
		this.connection = connection;
	}
}

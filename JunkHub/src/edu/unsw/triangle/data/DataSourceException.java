 package edu.unsw.triangle.data;

public class DataSourceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DataSourceException()
	{
		super();
	}
	
	public DataSourceException(String message, Exception e)
	{
		super(message,e);
	}
}

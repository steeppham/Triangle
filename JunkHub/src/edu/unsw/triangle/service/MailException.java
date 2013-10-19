package edu.unsw.triangle.service;

public class MailException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public MailException()
	{
		super();
	}
	
	public MailException(String message, Exception e)
	{
		super(message,e);
	}
}
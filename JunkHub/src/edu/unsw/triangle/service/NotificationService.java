package edu.unsw.triangle.service;

import java.util.logging.Logger;

public class NotificationService
{
	private final static Logger logger = Logger.getLogger(NotificationService.class.getName());
	
	public static void email(MailMessage message) throws MailException
	{
		MailSender mailSender = new MailSender();
		mailSender.send(message);
	}
	
	public static MailMessage createMessage()
	{
		return new MailMessage();
	}

	public static void notify(String address, String subject, String text) 
	{
		MailMessage message = createMessage().setBody(text).setRecipient(address).setSubject(subject).setFrom("admin@junkhub.com");
		
		try
		{
			email(message);	
			logger.info("notification sent to: " + address);
		}
		catch (MailException e)
		{
			logger.warning("notification failed to send to: " + address);
		}
	}
}

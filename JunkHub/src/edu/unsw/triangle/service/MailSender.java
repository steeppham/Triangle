package edu.unsw.triangle.service;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender 
{
	private final static Logger logger = Logger.getLogger(MailSender.class.getName());
	private Session session;
	public MailSender(int timeout, final String username, final String password)
	{
		// Set up mailing session
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
        props.put( "mail.smtp.connectiontimeout", timeout);
        props.put( "mail.smtp.timeout", timeout);
 
		session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		
	}
	
	public void send(MailMessage message) throws MailException
	{
		try
		{
			 Message msg = new MimeMessage(session);
	         msg.setFrom(new InternetAddress("admin@junkhub.com"));
	         msg.addRecipient(Message.RecipientType.TO, new InternetAddress(message.getRecipient()));
	         msg.setSubject(message.getSubject());
	         msg.setText(message.getBody());
	         Transport.send(msg);
		}
		catch (AddressException e)
		{
			logger.warning("invalid address sending to: " + message.getRecipient() + " reason: " + e.getMessage());
			throw new MailException("invalid address", e);
		}
		catch (MessagingException e)
		{
			logger.warning("message has failed to send to: " + message.getRecipient() + " reason: " + e.getMessage());
			throw new MailException("failed to send message", e);
		}
		
	}
}

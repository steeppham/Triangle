package edu.unsw.triangle.service;

import java.util.logging.Logger;

import edu.unsw.triangle.model.Bid;
import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.model.Profile;

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
	
	public static void notifyItemOwnerSold(String address, Item item)
	{
		String subject = String.format("JunkHub: Your item '%s' has sold!", item.getTitle());
		String message = String.format("Hello %d, item '%s' has been sold to '%s' for $%d", item.getOwner(), item.getTitle(), item.getBidder(), item.getBid());
		notify(address, subject, message);
	}
	
	public static void notifyItemBidderSold(String address, Item item)
	{
		String subject = String.format("JunkHub: You have won item '%s'!", item.getTitle());
		String message = String.format("Hello %d, you have successfuly won item '%s' for $%d", item.getBidder(), item.getTitle(), item.getBid());
		notify(address, subject, message);
	}

	public static void notifyItemOwnerPending(String address, Item item) 
	{
		String subject = String.format("JunkHub: Action required, your item '%s' did not meet reserve", item.getTitle());
		String message = String.format("Hello %d, please login to accept or decline bidder '%s' offer of $%d for item '%s'.\nhttp://localhost:8080/JunkHub/control/item?id=%d", 
				item.getOwner(), item.getBidder(), item.getBid(), item.getTitle(), item.getId());
		notify(address, subject, message);
	}

	public static void notifyItemOwnerUnsold(String address, Item item) 
	{
		String subject = String.format("JunkHub: Your item '%s' did not sell", item.getTitle());
		String message = String.format("Hello %d, item '%s' did not sell", item.getOwner(), item.getTitle());
		notify(address, subject, message);
	}

	public static void notifyItemBidderSuccess(String address, Item item, Bid bid) 
	{
		String subject = String.format("JunkHub: Your have successfully bidded for item '%s'", item.getTitle());
		String message = String.format("Hello %d, you have bidded $%d for item '%s'", bid.getBidder(), bid.getBid(), item.getTitle());
		notify(address, subject, message);
	}

	public static void notifyItemBidderLoss(String address, Item item, Bid bid) 
	{
		String subject = String.format("JunkHub: Your have been out bidded on item '%s", item.getTitle());
		String message = String.format("Hello %d, item '%s' has been out bidded by '%s'", item.getBidder(), item.getTitle(), bid.getBidder());
		notify(address, subject, message);
	}

	public static void notifyItemOwnerSuspend(String address, Item item) 
	{
		String subject = String.format("JunkHub: Your item '%s has been suspended", item.getTitle());
		String message = String.format("Hello %d, item '%s' has been out suspended by JunkHub", item.getOwner(), item.getTitle());
		notify(address, subject, message);
	}

	public static void notifyConfirmProfile(String address, Profile user) 
	{
		String subject = String.format("JunkHub: Activate your account for '%s'", user.getUsername());
		String confirmUrl = String.format("http://localhost:8080/JunkHub/control/confirm?username=%s&code=%d", user.getUsername(), user.hashCode());
		logger.info("generate unique activation url: " + confirmUrl);
		String message = String.format("Hello %s, please activate your account at %s", user.getUsername(), confirmUrl);
		notify(address, subject, message);
	}
}

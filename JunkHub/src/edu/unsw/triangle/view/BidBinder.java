package edu.unsw.triangle.view;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.Bid;
import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.model.WebSession;
import edu.unsw.triangle.service.ItemService;
import edu.unsw.triangle.util.Errors;

public class BidBinder implements RequestBinder {
	
	private final Logger logger = Logger.getLogger(BidBinder.class.getName());

	@Override
	public Object bindAndValidate(HttpServletRequest request, Errors errors) 
	{
		String itemId = request.getParameter("id");
		String bid = request.getParameter("bid");
		
		Bid bidObject = new Bid();
		try
		{
			bidObject.setItemId(Integer.parseInt(itemId));
		}
		catch (NumberFormatException e)
		{
			errors.rejectValue("id", "invalid item id");
		}
		
		try
		{
			bidObject.setBid(Float.parseFloat(bid));
		}
		catch (NumberFormatException e)
		{
			errors.rejectValue("bid", "bid is not a number");
		}
		
		// Get bidder from session
		WebSession websession = (WebSession) request.getSession().getAttribute("websession");
		bidObject.setBidder(websession.getUsername());
		
		// Get item from repository
		Item item = null;
		if (itemId != null)
		{
			try
			{
				item = ItemService.findItemById(bidObject.getItemId());
			}
			catch (Exception e)
			{
				// Error retrieving item
				logger.severe("failure to retrieve item id: " + bidObject.getItemId() + " reason: " + e.getMessage());
				e.printStackTrace();
				errors = new Errors().rejectValue("item.error", "repository failure reason:" + e.getMessage());
			}
		}
		bidObject.setItem(item);
		
		return bidObject;
	}

}

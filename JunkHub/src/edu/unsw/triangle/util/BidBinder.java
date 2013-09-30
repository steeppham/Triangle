package edu.unsw.triangle.util;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.Bid;
import edu.unsw.triangle.model.WebSession;

public class BidBinder implements RequestBinder {

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
		
		
		return bidObject;
	}

}

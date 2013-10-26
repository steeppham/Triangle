package edu.unsw.triangle.view;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.ItemPendingResult;
import edu.unsw.triangle.util.Errors;

public class ItemPendingBinder implements RequestBinder 
{
	@Override
	public Object bindAndValidate(HttpServletRequest request, Errors errors) 
	{
		String itemId = request.getParameter("id");
		String owner = request.getParameter("owner");
		String bidder = request.getParameter("bidder");
		String accept = request.getParameter("accept");
		String reject = request.getParameter("reject");
		
		ItemPendingResult itemPending = new ItemPendingResult();
		itemPending.setOwner(owner);
		itemPending.setBidder(bidder);
		try
		{
			itemPending.setItemId(Integer.parseInt(itemId));
		}
		catch (NumberFormatException e)
		{
			errors.rejectValue("id", "invalid item id");
		}
		
		if (accept == null && reject != null)
			itemPending.setAccept(false);
		else if (accept != null && reject == null)
			itemPending.setAccept(true);
		else
			errors.rejectValue("submit.pending", "invalid submit pending form");
		
		return itemPending;
	}

}

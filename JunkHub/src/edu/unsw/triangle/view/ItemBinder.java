package edu.unsw.triangle.view;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.model.Item.ItemStatus;
import edu.unsw.triangle.model.WebSession;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.ValidationUtility;

public class ItemBinder implements RequestBinder {

	@Override
	public Object bindAndValidate(HttpServletRequest request, Errors errors)
	{
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		String postage = request.getParameter("postage");
		String reserve = request.getParameter("reserve");
		String start = request.getParameter("start");
		String increment = request.getParameter("increment");
		String period = request.getParameter("period");
		
		Item item = new Item();
		item.setTitle(title).setCategory(category).setDescription(description).setPostage(postage);
		
		// Current time of server as start bid time
		item.setStartTime(new Date());
		
		// Parse bidding period
		if (period != null)
		{
			// Must be value between 3 to 60
			item.setPeriod(ValidationUtility.tryRejectNotInteger(errors, "period", period, "period must be a valid integer"));
		}
		else
		{
			// Default period value 3 min
			item.setPeriod(3);
		}
		
		// Parse reserve price
		item.setReserve(ValidationUtility.tryRejectNotFloat(errors, "reserve", reserve, "reserve price must be a valid number"));
		// Parse starting price
		item.setStart(ValidationUtility.tryRejectNotFloat(errors, "start", start, "starting price must be a valid number"));
		// Parse bid increment
		item.setIncrement(ValidationUtility.tryRejectNotFloat(errors, "increment", increment, "increment price must be a valid number"));
		
		// Add meta data
		WebSession websession = (WebSession) request.getSession().getAttribute("websession");
		item.setOwner(websession.getUsername());
		item.setStatus(ItemStatus.ACTIVE);
		
		return item;
	}
}

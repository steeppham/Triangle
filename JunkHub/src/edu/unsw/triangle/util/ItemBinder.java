package edu.unsw.triangle.util;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.Item;

public class ItemBinder implements RequestBinder {

	@Override
	public Object bindAndValidate(HttpServletRequest request, Errors errors)
	{
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String description = request.getParameter("desciption");
		String postage = request.getParameter("postage");
		String reserve = request.getParameter("reserve");
		String start = request.getParameter("start");
		String increment = request.getParameter("increment");
		
		Item item = new Item();
		item.setTitle(title).setCategory(category).setDescription(description).
		setPostage(postage);
		
		// Parse reserve price
		
		// Parse starting price
		
		// Parse bid increment
		
		return item;
	}

}

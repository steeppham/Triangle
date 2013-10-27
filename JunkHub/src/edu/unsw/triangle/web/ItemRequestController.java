package edu.unsw.triangle.web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.AbstractRequestController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.service.ItemService;
import edu.unsw.triangle.util.Errors;

public class ItemRequestController extends AbstractRequestController
{
	private final Logger logger = Logger.getLogger(LoginFormController.class.getName());
	
	@Override
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("handling item request");
		
		// Expect request contain parameter "id"
		String idString = request.getParameter("id");
		if (idString == null)
		{
			// Missing request parameter
			logger.warning("item request missing id parameter");
			Errors errors = new Errors();
			errors.rejectValue("request", "request missing item id");
			ModelView modelView = new ModelView(getFormView()).forward().addModel("errors", errors);
			return modelView;
		}
		
		// Parse id as number
		// TODO Exception handling here..
		int id = Integer.parseInt(idString);
		
		// Retrieve item from repository
		logger.info("retrieving item id:" + id + " from repository");
		Item item = ItemService.findItemById(id);
		
		if (item == null)
		{
			// Item not found
			logger.info("item id:" + id + " not found");
			Errors errors = new Errors();
			errors.rejectValue("request", "item not found");
			ModelView modelView = new ModelView(getFormView()).forward().addModel("errors", errors);
			return modelView;
		}
		
		ModelView modelView = new ModelView(getFormView()).forward().addModel("item", item);
		return modelView;
	}

	@Override
	public String getFormView() 
	{
		return "item.view";
	}

	@Override
	public String[] getRedirectObjects() {
		return new String[] {"pendingSuccess"};
	}

}

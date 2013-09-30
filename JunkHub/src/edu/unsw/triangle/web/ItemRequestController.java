package edu.unsw.triangle.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Controller;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.util.Errors;

public class ItemRequestController implements Controller
{
	private final Logger logger = Logger.getLogger(LoginFormController.class.getName());
	
	@Override
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("handling item request");
		// Expect request contain parameter "id"
		String id = request.getParameter("id");
		if (id == null)
		{
			// Missing request parameter
			logger.warning("item request missing id parameter");
			Errors errors = new Errors();
			errors.rejectValue("request", "request missing item id");
			ModelView modelView = new ModelView(getFormView()).forward().addModel("errors", errors);
			return modelView;
		}
		
		// Service layer here...
		logger.info("retrieving item id:" + id + " from repository");
		Item item = new Item();
		item.setTitle("jeans").setCategory("clothes").setDescription("best jeans ever");
		ModelView modelView = new ModelView(getFormView()).forward().addModel("item", item);
		return modelView;
	}

	@Override
	public String getFormView() 
	{
		return "item.view";
	}

}

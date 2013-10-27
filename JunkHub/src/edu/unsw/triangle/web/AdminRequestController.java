package edu.unsw.triangle.web;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Controller;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.model.WebSession;
import edu.unsw.triangle.service.ItemService;
import edu.unsw.triangle.service.ProfileService;
import edu.unsw.triangle.util.Errors;

public class AdminRequestController implements Controller 
{
	private final Logger logger = Logger.getLogger(ItemFormController.class.getName());
	@Override
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		// Retrieve list of users 
		List<Profile> profiles = null;
		List<Item> items = null;
		ModelView modelView = null;
		Errors errors = new Errors();
		
		// Guard view for administrator only
		WebSession websession = (WebSession) request.getSession().getAttribute("websession");
		if (!websession.getProfile().isAdmin())
		{
			//Not admin, redirect to error page
			logger.info("user does not have permissions to access admin portal");
			errors.rejectValue("error", websession.getUsername() + " does not have permission to access admin");
			return modelView = new ModelView("error.view").addModel("errors", errors);
		}
		
		try
		{
			logger.info("retrieving all profiles");
			profiles = ProfileService.findAllProfiles();
			
		}
		catch (Exception e)
		{
			logger.severe("failed to retrieved profile list from repository");
			errors.rejectValue("admin.profiles.error", "profiles failed to be retrieved reason " + e.getMessage());
		}
		
		// Retrieve list of items
		try
		{
			logger.info("retrieving all items");
			items = ItemService.findAllItems();
		}
		catch (Exception e)
		{
			logger.severe("failed to retrieved item list from repository");
			errors.rejectValue("admin.items.error", "items failed to be retrieved reason " + e.getMessage());
		}
		
		modelView = new ModelView(getFormView()).forward().addModel("items", items).addModel("profiles", profiles);
		
		return modelView;
	}

	@Override
	public String getFormView() 
	{
		return "admin.view";
	}
}

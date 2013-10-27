package edu.unsw.triangle.web;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.service.ItemService;
import edu.unsw.triangle.service.ProfileService;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.Validator;
import edu.unsw.triangle.view.AdminItemBinder;
import edu.unsw.triangle.view.RequestBinder;

public class AdminItemFormController extends AbstractFormController {

	private final Logger logger = Logger.getLogger(AdminItemFormController.class.getName());
	
	@Override
	public String getFormView() {
		return "admin.view";
	}

	@Override
	protected Object createBackingObject(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ModelView handleFormSubmit(Object command) 
	{
		List<Integer> items = (List<Integer>) command;
		logger.info("Suspend items id: " + items);
		
		// Halt item by id
		logger.info("Suspend items of users: " + items);
		try
		{
			ItemService.suspendItem(items);
		}
		catch (Exception e)
		{
			logger.severe("failed to halt items reason: " + e.getMessage());
			Errors errors = new Errors().rejectValue("admin.items.error", "failed to halt items reason: " + e.getMessage());
			return handleFormError(null, errors);
		}
		
		// Message model here.
		ModelView modelView = new ModelView(getSuccessView()).redirect();
		return modelView;
	}

	@Override
	protected Validator getValidator() {
		// Validator not implemented
		return null;
	}

	@Override
	protected RequestBinder getBinder() {
		return new AdminItemBinder();
	}

	@Override
	protected String getSuccessView() {
		return "admin";
	}

	@Override
	protected ModelView handleFormError(Object command, Errors errors) {
		ModelView modelView = new ModelView(getFormView()).forward().
				addModel("errors", errors);
		return modelView;
	}
}

package edu.unsw.triangle.web;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.ItemBinder;
import edu.unsw.triangle.util.ItemValidator;
import edu.unsw.triangle.util.Messages;
import edu.unsw.triangle.util.RequestBinder;
import edu.unsw.triangle.util.Validator;

public class SellFormController extends AbstractFormController 
{
	@Override
	public String getFormView() 
	{
		return "sell.view";
	}

	@Override
	protected Object createBackingObject(HttpServletRequest request) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ModelView handleFormSubmit(Object command) 
	{
		Item item = (Item) command;
		
		// Service operations here
		
		// Success message
		Messages message = new Messages();
		message.add("success", "item is saved");
		
		ModelView modelView = new ModelView(getSuccessView()).addModel("message", message);		
		return modelView;
	}

	@Override
	protected Validator getValidator() 
	{
		return new ItemValidator();
	}

	@Override
	protected RequestBinder getBinder() 
	{
		return new ItemBinder();
	}

	@Override
	protected String getSuccessView() 
	{
		return "sell.confirm.view";
	}

	@Override
	protected ModelView handleFormError(Object command, Errors errors) 
	{
		ModelView modelView = new ModelView(getFormView()).forward().
				addModel("item", command).addModel("errors", errors);
		return modelView;
	}

}

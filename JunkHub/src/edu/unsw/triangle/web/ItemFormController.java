package edu.unsw.triangle.web;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Bid;
import edu.unsw.triangle.util.BidBinder;
import edu.unsw.triangle.util.BidValidator;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.RequestBinder;
import edu.unsw.triangle.util.Validator;

public class ItemFormController extends AbstractFormController {

	@Override
	public String getFormView() 
	{
		return "item.view";
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
		Bid bid = (Bid) command;
		
		// Servicer handler here...
		// Message session here...
		ModelView modelView = new ModelView(getSuccessView()).redirect();
		
		return modelView;
	}

	@Override
	protected Validator getValidator() 
	{
		return new BidValidator();
	}

	@Override
	protected RequestBinder getBinder() 
	{
		return new BidBinder();
	}

	@Override
	protected String getSuccessView() 
	{
		return "item";
	}

	@Override
	protected ModelView handleFormError(Object command, Errors errors) 
	{
		ModelView modelView = new ModelView(getFormView()).forward().
				addModel("errors", errors);
		return modelView;
	}

}

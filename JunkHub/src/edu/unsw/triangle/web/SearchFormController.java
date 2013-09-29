package edu.unsw.triangle.web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.FrontController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.model.Query;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.RequestBinder;
import edu.unsw.triangle.util.SearchBinder;
import edu.unsw.triangle.util.SearchValidator;
import edu.unsw.triangle.util.Validator;

public class SearchFormController extends AbstractFormController
{
	private final static Logger logger = Logger.getLogger(FrontController.class.getName());
	
	@Override
	public String getFormView() 
	{
		return "main.view";
	}

	@Override
	protected Object createBackingObject(HttpServletRequest request) 
	{
		
		return null;
	}

	@Override
	protected ModelView handleFormSubmit(Object command) 
	{
		Query query = (Query) command;
		
		// Search service here..
		//ItemCollection result = SearchService.search();
		
		List<Item> results = new ArrayList<Item>();
		logger.info(String.format("Search query \"%s\" returned %d results", query, results.size()));
		
		ModelView modelView = new ModelView(getSuccessView()).forward().addModel("query", query).addModel("result", results);
		return modelView;
	}

	@Override
	protected Validator getValidator() 
	{
		return new SearchValidator();
	}

	@Override
	protected RequestBinder getBinder() 
	{
		return new SearchBinder();
	}

	@Override
	protected String getSuccessView() 
	{
		return "main.view";
	}

	@Override
	protected ModelView handleFormError(Object command, Errors errors) 
	{
		ModelView modelView = new ModelView(getFormView()).forward().
				addModel("search", command).addModel("errors", errors);
		return modelView;
	}

}

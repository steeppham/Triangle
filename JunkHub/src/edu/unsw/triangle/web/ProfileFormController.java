package edu.unsw.triangle.web;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.ProfileValidator;
import edu.unsw.triangle.util.Validator;
import edu.unsw.triangle.view.ProfileBinder;
import edu.unsw.triangle.view.RequestBinder;

public class ProfileFormController extends AbstractFormController 
{
	@Override
	public String getFormView() 
	{
		return "profile.view";
	}

	@Override
	protected Object createBackingObject(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ModelView handleFormSubmit(Object command) 
	{
		Profile updatedProfile = (Profile) command;
		
		// Service provider here
		ModelView modelView = new ModelView(getFormView()).forward().addModel("profile", updatedProfile);
		
		return modelView;
	}

	@Override
	protected Validator getValidator() 
	{
		return new ProfileValidator();
	}

	@Override
	protected RequestBinder getBinder() 
	{
		return new ProfileBinder();
	}

	@Override
	protected String getSuccessView() 
	{
		return "profile.view";
	}

	@Override
	protected ModelView handleFormError(Object command, Errors errors) 
	{
		ModelView modelView = new ModelView(getFormView()).forward().
				addModel("profile.error", command).addModel("errors", errors);
		return modelView;
	}

}

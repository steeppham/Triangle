package edu.unsw.triangle.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.data.ConnectionManager;
import edu.unsw.triangle.data.DerbyDaoManager;
import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.model.Profile.AccountStatus;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.ProfileValidator;
import edu.unsw.triangle.util.Validator;
import edu.unsw.triangle.view.ProfileBinder;
import edu.unsw.triangle.view.RequestBinder;

public class RegisterFormController extends AbstractFormController 
{
	private final Logger logger = Logger.getLogger(RegisterFormController.class.getName());
	
	@Override
	protected Object createBackingObject(HttpServletRequest request) 
	{
		return null;
	}

	@Override
	protected ModelView handleFormSubmit(Object command) 
	{
		logger.info("handling register form submit request");
		Profile profile = (Profile) command;
		ModelView modelView = null;
		// Service provider here...
		//input data
		
		try 
		{
			DerbyDaoManager derbyManager = new DerbyDaoManager(ConnectionManager.getInstance());
			
			// check if username is free
			if (derbyManager.getProfileDao().findByUsername(profile.getUsername()) == null)
			{
				// insert new profile into repository
				// set profile to default for new user
				profile.setAdmin(false).setStatus(AccountStatus.ACTIVE); //TODO change this for confirmation
				derbyManager.getProfileDao().insert(profile);
				modelView = new ModelView(getSuccessView()).forward().addModel("profile", command);
			}
			else
			{
				// username already taken
				logger.info("username " + profile.getUsername() + " is already taken");
				Errors errors = new Errors().rejectValue("username", "username is alredy taken");
				modelView = handleFormError(profile, errors);
			}
			derbyManager.close();
		} 
		catch (Exception e)
		{
			logger.severe("failed to create profile for " + profile.getUsername() + " reason " + e.getMessage());
			Errors errors = new Errors().rejectValue("register.error", "failed to create profile reason " + e.getMessage());
			modelView = handleFormError(profile, errors);
		}
		
		return modelView;
	}

	@Override
	protected Validator getValidator() 
	{
		return new ProfileValidator();
	}

	@Override
	protected String getSuccessView() 
	{
		return "confirm";
	}

	@Override
	protected ModelView handleFormError(Object command, Errors errors) 
	{
		ModelView modelView = new ModelView(getFormView()).forward().
				addModel("profile", command).addModel("errors", errors);
		return modelView;
	}

	@Override
	protected RequestBinder getBinder() 
	{
		return new ProfileBinder();
	}

	@Override
	public String getFormView() 
	{
		return "register.view";
	}

}

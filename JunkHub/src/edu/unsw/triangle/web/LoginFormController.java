package edu.unsw.triangle.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Login;
import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.model.WebSession;
import edu.unsw.triangle.model.Profile.AccountStatus;
import edu.unsw.triangle.service.LoginService;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.LoginValidator;
import edu.unsw.triangle.util.Validator;
import edu.unsw.triangle.view.LoginBinder;
import edu.unsw.triangle.view.RequestBinder;

public class LoginFormController extends AbstractFormController 
{
	private final Logger logger = Logger.getLogger(LoginFormController.class.getName());
	
	@Override
	protected Object createBackingObject(HttpServletRequest request) 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login();
		login.setPassword(password);
		login.setUsername(username);
		return login;
	}

	@Override
	protected ModelView handleFormSubmit(Object command) 
	{
		logger.info("handling login form submit");
		Login login = (Login) command;
		ModelView modelView;
		Profile profile = null;
		
		// Call service layer to authenticate
		try 
		{
			profile = LoginService.authenticate(login);
		}
		catch (Exception e)
		{
			logger.info("authentication failure reason:" + e.getMessage());
			Errors errors = new Errors();
			errors.rejectValue("authentication", "authentication failure reason: " + e.getMessage());
			return modelView = handleFormError(login, errors).addModel("login", login);
		}
		
		if (profile == null)
		{
			// Not authenticated
			logger.info("incorrect username or password for: " + login.getUsername());
			Errors errors = new Errors();
			errors.rejectValue("authentication", "Incorrect username and/or password");
			return modelView = handleFormError(login, errors).addModel("login", login);
		}
		
		if (profile.getStatus() == AccountStatus.ACTIVE)
		{
			// Authenticated
			logger.info("authenticated for username: " + login.getUsername());
			modelView = new ModelView(getSuccessView()).redirect();
			
			// Create new web session and add to model
			WebSession websession = new WebSession();
			websession.setUsername(login.getUsername());
			websession.setProfile(profile);
			modelView.addSessionModel("websession", websession);
		}
		else if (profile.getStatus() == AccountStatus.NOT_ACTIVE)
		{
			// User banned
			logger.info(login.getUsername() + " has no access");
			Errors errors = new Errors();
			errors.rejectValue("authentication", "access has been revoked");
			modelView = handleFormError(login, errors).addModel("login", login);
		}
		else if (profile.getStatus() == AccountStatus.PENDING)
		{
			// User has not confirmed registration
			logger.info("confirmation invalid for: " + login.getUsername());
			Errors errors = new Errors();
			errors.rejectValue("authentication", "please confirm registration before logining in");
			modelView = handleFormError(login, errors).addModel("login", login);
		}
		else
		{
			// invalid state
			logger.info("invalid account status");
			Errors errors = new Errors();
			errors.rejectValue("authentication", "invalid account status");
			modelView = handleFormError(login, errors).addModel("login", login);
		}
		
		modelView.addModel("login", login);
		
		return modelView;
	}

	@Override
	protected Validator getValidator() 
	{
		return new LoginValidator();
	}

	@Override
	protected String getSuccessView() 
	{
		return "main";
	}

	@Override
	protected ModelView handleFormError(Object command, Errors errors) 
	{
		ModelView modelView = new ModelView(getFormView()).forward().
				addModel("errors", errors).addModel("login", command);
		return modelView;
	}

	@Override
	protected RequestBinder getBinder() 
	{
		return new LoginBinder();
	}

	@Override
	public String getFormView() {
		return "login.view";
	}
}

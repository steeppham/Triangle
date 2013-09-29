package edu.unsw.triangle.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Login;
import edu.unsw.triangle.model.WebSession;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.LoginBinder;
import edu.unsw.triangle.util.LoginValidator;
import edu.unsw.triangle.util.RequestBinder;
import edu.unsw.triangle.util.Validator;

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
		//TODO Implement service
		// Authenticate with service here...
		if (login.getUsername().equals("stephen"))
		{
			// Authenticated
			logger.info("authenticated for username: " + login.getUsername());
			modelView = new ModelView(getSuccessView()).redirect();
			
			// Create new web session and add to model
			WebSession websession = new WebSession();
			websession.setUsername(login.getUsername());
			modelView.addSessionModel("websession", websession);
		}
		else
		{
			// Not authenticated
			logger.info("authentication failed for username: " + login.getUsername());
			Errors errors = new Errors();
			errors.rejectValue("authentication", "Incorrect username and/or password");
			modelView = handleFormError(login, errors);
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
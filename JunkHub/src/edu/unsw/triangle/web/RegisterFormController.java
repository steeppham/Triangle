package edu.unsw.triangle.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.ModelView;
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String credit = request.getParameter("credit");
		String dob = request.getParameter("dob");
		
		return null;
	}

	@Override
	protected ModelView handleFormSubmit(Object command) 
	{
		logger.info("handling register form submit request");
		
		// Service provider here...
		ModelView modelView = new ModelView(getSuccessView()).redirect();
		modelView.addModel("profile", command);
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

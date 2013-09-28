package edu.unsw.triangle.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.Validator;
import edu.unsw.triangle.web.LoginFormController;

public abstract class AbstractFormController implements Controller {

	private final Logger logger = Logger.getLogger(AbstractFormController.class.getName());
	
	@Override
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		Object command = createBackingObject(request);
		Errors errors = new Errors();
		getValidator().validate(command, errors);
		if (errors.hasErrors())
		{
			logger.warning("Form validation has errors");
			return handleFormError(errors);
		}
		
		return handleFormSubmit(command);
	}
	
	
	abstract protected Object createBackingObject(HttpServletRequest request);
	
	abstract protected ModelView handleFormSubmit(Object command);
	
	abstract protected Validator getValidator();
	
	abstract protected String getSuccessView();
	
	abstract protected ModelView handleFormError(Errors errors);

}

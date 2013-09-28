package edu.unsw.triangle.web;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.Validator;

public class RegisterFormController extends AbstractFormController 
{
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
	protected ModelView handleFormSubmit(Object command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSuccessView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ModelView handleFormError(Errors errors) {
		// TODO Auto-generated method stub
		return null;
	}

}

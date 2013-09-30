package edu.unsw.triangle.view;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.Login;
import edu.unsw.triangle.util.Errors;

public class LoginBinder implements RequestBinder {

	@Override
	public Object bindAndValidate(HttpServletRequest request, Errors errors) 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login();
		login.setPassword(password);
		login.setUsername(username);
		return login;
	}
}

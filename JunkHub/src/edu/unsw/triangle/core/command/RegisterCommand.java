package edu.unsw.triangle.core.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.core.Command;
import edu.unsw.triangle.view.View;

public class RegisterCommand implements Command 
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		return View.REGISTER;
	}

}

package edu.unsw.triangle.core.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.core.Command;
import edu.unsw.triangle.core.Dispatcher;

public class RegisterPageRequest implements Command 
{

	@Override
	public Dispatcher execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		return null;
	}

}

package edu.unsw.triangle.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.control.Command;
import edu.unsw.triangle.control.Dispatcher;
import edu.unsw.triangle.view.RegisterViewHelper;
import edu.unsw.triangle.view.ViewAction;

/**
 * Implementation for handling GET register page request.
 */
public class RegisterPageRequest implements Command 
{
	@Override
	public Dispatcher execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		return new Dispatcher.DispatcherBuilder(RegisterViewHelper.REGISTER_VIEW).action(ViewAction.FORWARD).build();
	}

}

package edu.unsw.triangle.core.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.core.Command;
import edu.unsw.triangle.core.Dispatcher;
import edu.unsw.triangle.ui.RegisterViewHelper;
import edu.unsw.triangle.ui.ViewAction;

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

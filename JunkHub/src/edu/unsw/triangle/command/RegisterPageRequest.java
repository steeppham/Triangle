package edu.unsw.triangle.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Command;
import edu.unsw.triangle.controller.Dispatcher2;
import edu.unsw.triangle.view.RegisterViewHelper;
import edu.unsw.triangle.view.ViewAction;

/**
 * Implementation for handling GET register page request.
 */
@Deprecated
public class RegisterPageRequest implements Command 
{
	@Override
	public Dispatcher2 handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		return new Dispatcher2.DispatcherBuilder(RegisterViewHelper.REGISTER_VIEW).action(ViewAction.FORWARD).build();
	}

}

package edu.unsw.triangle.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.control.Command;
import edu.unsw.triangle.control.Dispatcher;
import edu.unsw.triangle.view.ViewAction;

/**
 * Handles the confirmation of user profile registration through uniquely generated URL.
 */
public class ConfirmPageRequest implements Command {

	@Override
	public Dispatcher execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		return new Dispatcher.DispatcherBuilder("confirm.jsp").action(ViewAction.FORWARD).build();
	}

}

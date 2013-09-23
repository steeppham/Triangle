package edu.unsw.triangle.core.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.core.Command;
import edu.unsw.triangle.core.Dispatcher;
import edu.unsw.triangle.ui.ViewAction;

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

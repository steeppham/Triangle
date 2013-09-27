package edu.unsw.triangle.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Command;
import edu.unsw.triangle.controller.Dispatcher2;
import edu.unsw.triangle.view.ViewAction;

/**
 * Handles the confirmation of user profile registration through uniquely generated URL.
 */
public class ConfirmPageRequest implements Command {

	@Override
	public Dispatcher2 handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		return new Dispatcher2.DispatcherBuilder("confirm.jsp").action(ViewAction.FORWARD).build();
	}

}
